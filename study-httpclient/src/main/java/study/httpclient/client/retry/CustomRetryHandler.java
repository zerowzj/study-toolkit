package study.httpclient.client.retry;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

@Slf4j
public class CustomRetryHandler implements HttpRequestRetryHandler {

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
            log.info("执行次数[{}]超过最大执行次数[{}]", executionCount, maxExeCount);
            return false;
        }

        //未知主机
        if (exception instanceof UnknownHostException) {
            log.info("UnknownHostException");
            return true;
        } else if (exception instanceof SSLHandshakeException) { //SSL握手异常
            log.info("SSLHandshakeException");
            return false;
        }
        //
        if (exception instanceof InterruptedIOException) {
            log.info("InterruptedIOException");
            return false;
        } else if (exception instanceof ConnectTimeoutException) {  //连接超时
            log.info("ConnectTimeoutException");
            return false;
        } else if (exception instanceof SSLException) { // ssl握手异常不重试
            log.info("SSLException");
            return false;
        } else if (exception instanceof NoHttpResponseException) { //如果服务器丢掉了连接，那么就重试
            log.info("NoHttpResponseException");
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
