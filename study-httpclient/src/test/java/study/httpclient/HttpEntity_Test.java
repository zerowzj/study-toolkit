package study.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

public class HttpEntity_Test extends HttpClient_Test {

    @Test
    public void test_StringEntity() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost();
        try {
            //
            StringEntity entity = new StringEntity("");
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test_UrlEncodedFormEntity() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost();
        try {
            //
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(null);
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
