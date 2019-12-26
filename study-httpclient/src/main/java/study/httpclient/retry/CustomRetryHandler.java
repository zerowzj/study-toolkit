package study.httpclient.retry;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

public class CustomRetryHandler implements HttpRequestRetryHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomRetryHandler.class);

    private int maxExeCount;

    public CustomRetryHandler() {
        this(3);
    }

    public CustomRetryHandler(int maxExeCount) {
        this.maxExeCount = maxExeCount;
    }

    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        //超过重试次数
        if (executionCount > maxExeCount) {
            LOGGER.info("执行次数[{}]超过最大执行次数[{}]", executionCount, maxExeCount);
            return false;
        }

        //未知主机
        if (exception instanceof UnknownHostException) {
            LOGGER.info("UnknownHostException");
            return true;
        }
        //SSL握手异常
        if (exception instanceof SSLHandshakeException) {
            LOGGER.info("SSLHandshakeException");
            return false;
        }
        //
        if (exception instanceof InterruptedIOException) {
            LOGGER.info("InterruptedIOException");
            return false;
        }
        //连接超时
        if (exception instanceof ConnectTimeoutException) {
            LOGGER.info("ConnectTimeoutException");
            return false;
        }
        // ssl握手异常不重试
        if (exception instanceof SSLException) {
            LOGGER.info("SSLException");
            return false;
        }
        //如果服务器丢掉了连接，那么就重试
        if (exception instanceof NoHttpResponseException) {
            LOGGER.info("NoHttpResponseException");
            return true;
        }

        HttpClientContext clientContext = HttpClientContext.adapt(context);
        HttpRequest request = clientContext.getRequest();
        // 如果请求是幂等的，就再次尝试
        if (!(request instanceof HttpEntityEnclosingRequest)) {
            return true;
        }
        return false;
    }
}
