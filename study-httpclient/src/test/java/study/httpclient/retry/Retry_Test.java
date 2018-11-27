package study.httpclient.retry;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import study.httpclient.HttpClient_Test;

import java.io.IOException;

public class Retry_Test extends HttpClient_Test {

    @Test
    public void test() {
        HttpClient client = HttpClients.custom()
                .setRetryHandler(new CustomRetryHandler())
                .build();
        try {
            HttpPost post = new HttpPost(URL + "C");
            LOGGER.info("==============>");
            client.execute(post);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
