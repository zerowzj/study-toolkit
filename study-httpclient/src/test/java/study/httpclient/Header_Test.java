package study.httpclient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class Header_Test extends HttpClient_Test {

    @Test
    public void get_test() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.163.com");

//        httpGet.setHeader();
//        httpGet.addHeader();
    }

    @Test
    public void post_test() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://www.163.com");

//        httpPost.setHeader();
//        httpPost.addHeader();
    }
}
