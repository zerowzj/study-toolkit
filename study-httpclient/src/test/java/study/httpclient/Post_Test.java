package study.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

public class Post_Test extends HttpClient_Test {

    @Test
    public void test() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://www.163.com");
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            int StatusCode = httpResponse.getStatusLine().getStatusCode();
            String StatusDescription = httpResponse.getStatusLine().getReasonPhrase();
            LOGGER.info("StatusCode: {}", StatusCode);
            LOGGER.info("StatusDescription: {}", StatusDescription);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
