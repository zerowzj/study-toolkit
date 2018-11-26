package study.httpclient.method;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import study.httpclient.HttpClient_Test;

import java.io.IOException;

public class Get_Test extends HttpClient_Test {

    @Test
    public void test() {
        HttpGet httpGet = new HttpGet(URL);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            //
            StatusLine statusLine = httpResponse.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            String reasonPhrase = statusLine.getReasonPhrase();
            LOGGER.info("statusCode={}, reasonPhrase={}", statusCode, reasonPhrase);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
