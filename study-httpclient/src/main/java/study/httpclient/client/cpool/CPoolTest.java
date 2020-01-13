package study.httpclient.client.cpool;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.*;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Test;

import java.nio.charset.CodingErrorAction;

@Slf4j
public class CPoolTest {

    @Test
    public void test() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        //最大连接数
        connManager.setMaxTotal(200);
        //路由最大连接数
        connManager.setDefaultMaxPerRoute(100);
        connManager.setMaxPerRoute(new HttpRoute(new HttpHost("somehost")), 150);  //设置到某个路由的最大连接数

        //（★）Socket配置（默认配置和某个Host的配置）
        SocketConfig socketConfig = SocketConfig.custom()
                .setTcpNoDelay(true)     //是否立即发送数据，设置为true会关闭Socket缓冲，默认为false
                .setSoReuseAddress(true) //是否可以在一个进程关闭Socket后，即使它还没有释放端口，其它进程还可以立即重用端口
                .setSoTimeout(500)       //接收数据的等待超时时间，单位ms
                .setSoLinger(60)         //关闭Socket时，要么发送完所有数据，要么等待60s后，就关闭连接，此时socket.close()是阻塞的
                .setSoKeepAlive(true)    //开启监视TCP连接是否有效
                .build();
        connManager.setDefaultSocketConfig(socketConfig);
        connManager.setSocketConfig(new HttpHost("somehost"), socketConfig);

        //消息约束
        MessageConstraints messageConstraints = MessageConstraints.custom()
                .setMaxHeaderCount(200)
                .setMaxLineLength(2000)
                .build();
        //（★）Connection配置（默认配置和某个Host的配置）
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8)
                .setMessageConstraints(messageConstraints)
                .build();
        connManager.setDefaultConnectionConfig(connectionConfig);
        connManager.setSocketConfig(new HttpHost("somehost"), socketConfig);

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

        HttpClient client = HttpClients.custom()
                .setConnectionManager(connManager)
                .build();
    }
}

