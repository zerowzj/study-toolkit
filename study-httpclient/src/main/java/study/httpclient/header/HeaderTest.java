package study.httpclient.header;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class HeaderTest {

    private static final String URL = "http://www.sohu.com";

    @Test
    public void get_test() throws Exception {
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setHeader("Request-Id", "6666666666");

        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);

        Header[] headers = response.getAllHeaders();
        Arrays.asList(headers).forEach(header -> {
            log.info("{}={}", header.getName(), header.getValue());
        });
    }

    @Test
    public void post_test() throws Exception {
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setHeader("Request-Id", "6666666666");

        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpPost);

        Header[] headers = response.getAllHeaders();
        Arrays.asList(headers).forEach(header -> {
            log.info("{}={}", header.getName(), header.getValue());
        });
    }
}
