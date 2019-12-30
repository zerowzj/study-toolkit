package study.httpclient.client.post;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

@Slf4j
public class HttpClientTest {

    @Test
    public void test() {
        HttpClient client = HttpClients.custom()
                .setConnectionManager(null)
                .build();
    }
}
