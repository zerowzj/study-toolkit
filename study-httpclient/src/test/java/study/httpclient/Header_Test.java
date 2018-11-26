package study.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;

import java.io.IOException;

public class Header_Test extends HttpClient_Test {

    @Test
    public void get_test() {
        HttpGet httpGet = new HttpGet(URL);
//        httpGet.setHeader();
//        httpGet.addHeader();
        try {
            HttpResponse response = httpClient.execute(httpGet);
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                LOGGER.info("name={}, value={}", header.getName(), header.getValue());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void post_test() {
        HttpPost httpPost = new HttpPost(URL);
//        httpPost.setHeader();
//        httpPost.addHeader();
        try {
            HttpResponse response = httpClient.execute(httpPost);
            //
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                LOGGER.info("name: {}, value: {}", header.getName(), header.getValue());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
