package study.httpclient;

import org.apache.http.StatusLine;
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
        HttpPost httpPost = new HttpPost(URL);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            //
            StatusLine statusLine = httpResponse.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            String reasonPhrase = statusLine.getReasonPhrase();
            LOGGER.info("statusCode: {}, reasonPhrase: {}", statusCode, reasonPhrase);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
