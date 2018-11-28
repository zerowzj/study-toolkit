package study.httpclient.cpool;

import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Test;

import java.nio.charset.CodingErrorAction;

public class CPool_Test {

    @Test
    public void test() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        //最大连接数
        connManager.setMaxTotal(200);
        //默认的每个路由的最大连接数
        connManager.setDefaultMaxPerRoute(100);
        //设置到某个路由的最大连接数，会覆盖defaultMaxPerRoute
        connManager.setMaxPerRoute(new HttpRoute(new HttpHost("somehost", 80)), 150);

        /**
         * 连接数相关设置
         */
        SocketConfig socketConfig = SocketConfig.custom()
                .setTcpNoDelay(true)     //是否立即发送数据，设置为true会关闭Socket缓冲，默认为false
                .setSoReuseAddress(true) //是否可以在一个进程关闭Socket后，即使它还没有释放端口，其它进程还可以立即重用端口
                .setSoTimeout(500)       //接收数据的等待超时时间，单位ms
                .setSoLinger(60)         //关闭Socket时，要么发送完所有数据，要么等待60s后，就关闭连接，此时socket.close()是阻塞的
                .setSoKeepAlive(true)    //开启监视TCP连接是否有效
                .build();
        connManager.setDefaultSocketConfig(socketConfig);
        connManager.setSocketConfig(new HttpHost("somehost", 80), socketConfig);

        /**
         * HTTP connection相关配置（默认配置 和 某个host的配置）
         * 一般不修改HTTP connection相关配置，故不设置
         */
        //消息约束
        MessageConstraints messageConstraints = MessageConstraints.custom()
                .setMaxHeaderCount(200)
                .setMaxLineLength(2000)
                .build();
        //Http connection相关配置
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8)
                .setMessageConstraints(messageConstraints)
                .build();

        /**
         * request请求相关配置
         */
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(2 * 1000)         //连接超时时间
                .setSocketTimeout(2 * 1000)          //读超时时间（等待数据超时时间）
                .setConnectionRequestTimeout(500)    //从池中获取连接超时时间
                .setStaleConnectionCheckEnabled(true)//检查是否为陈旧的连接，默认为true，类似testOnBorrow
                .build();

        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainsf)
                .register("https", sslsf)
                .build();
    }
}

