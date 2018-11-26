package study.httpclient.entity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import study.httpclient.HttpClient_Test;

import java.io.IOException;

public class MultipartEntity_Test extends HttpClient_Test {

    /**
     *
     */
    @Test
    public void test() {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addBinaryBody()
//        builder.addTextBody()
        HttpEntity entity = builder.build();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
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
