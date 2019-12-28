package study.httpclient.header;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
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

        HttpHost proxy = new HttpHost("127.0.0.1", 8888);
        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .setConnectTimeout(10000)
                .setSocketTimeout(10000)
                .setConnectionRequestTimeout(3000)
                .build();

        HttpGet httpGet = new HttpGet(URL);
        httpGet.setHeader("Request-Id", "6666666666");
        httpGet.setHeader("Request-Idxxx", "12312");
        httpGet.setHeader("Request-Idbabsad", "123123123");
        httpGet.setConfig(requestConfig);

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
        httpPost.setHeader("Request-Id", "999999999");

        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpPost);

        Header[] headers = response.getAllHeaders();
        Arrays.asList(headers).forEach(header -> {
            log.info("{}={}", header.getName(), header.getValue());
        });
    }
}
