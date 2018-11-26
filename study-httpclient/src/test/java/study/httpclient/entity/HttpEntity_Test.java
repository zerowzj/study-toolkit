package study.httpclient.entity;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import study.httpclient.HttpClient_Test;

import java.io.IOException;

public class HttpEntity_Test extends HttpClient_Test {

    /**
     *
     */
    @Test
    public void test_StringEntity() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            //TODO
            StringEntity entity = new StringEntity("");

            HttpPost httpPost = new HttpPost();
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     */
    @Test
    public void test_UrlEncodedFormEntity() {
        try {
            //TODO
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(null);

            HttpPost httpPost = new HttpPost();
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
