package study.httpclient.cpool;

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

    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        if (executionCount >= 5) {// 如果已经重试了5次不重试
            LOGGER.info("", executionCount);
            return false;
        }

        //
        if (exception instanceof SSLHandshakeException) {//不要重试SSL握手异常
            return false;
        }
        //
        if (exception instanceof InterruptedIOException) {//超时不重试
            return false;
        }
        //
        if (exception instanceof UnknownHostException) {//目标服务器不可达不重试
            return false;
        }
        //
        if (exception instanceof ConnectTimeoutException) {//连接被拒绝不重试
            return false;
        }
        if (exception instanceof SSLException) {// ssl握手异常不重试
            return false;
        }
        if (exception instanceof NoHttpResponseException) { //如果服务器丢掉了连接，那么就重试
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
