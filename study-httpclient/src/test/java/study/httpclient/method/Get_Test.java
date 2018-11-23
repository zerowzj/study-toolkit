package study.httpclient.method;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import study.httpclient.HttpClient_Test;

import java.io.IOException;

public class Get_Test extends HttpClient_Test {

    @Test
    public void test() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            int StatusCode = httpResponse.getStatusLine().getStatusCode();
            String StatusDescription = httpResponse.getStatusLine().getReasonPhrase();
            System.out.println("StatusCode: " + StatusCode);
            System.out.println("StatusDescription: " + StatusDescription);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
