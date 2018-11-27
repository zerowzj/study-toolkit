package study.httpclient.entity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
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

        try {
            HttpPost httpPost = new HttpPost();
            httpPost.setEntity(entity);

            HttpResponse response = client.execute(httpPost);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
