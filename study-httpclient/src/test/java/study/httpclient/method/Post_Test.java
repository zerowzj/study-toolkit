package study.httpclient.method;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;
import study.httpclient.HttpClient_Test;

import java.io.IOException;

public class Post_Test extends HttpClient_Test {

    @Test
    public void test() {
        HttpPost httpPost = new HttpPost(URL);
        try {
            CloseableHttpResponse response = client.execute(httpPost);
            //
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            String reasonPhrase = statusLine.getReasonPhrase();
            LOGGER.info("statusCode: {}, reasonPhrase: {}", statusCode, reasonPhrase);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
