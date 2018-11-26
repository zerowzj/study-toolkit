package study.httpclient.cpool;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Test;

public class CPool_Test {

    @Test
    public void test(){
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();

        HttpClients.custom().setConnectionManager(manager);
    }
}

