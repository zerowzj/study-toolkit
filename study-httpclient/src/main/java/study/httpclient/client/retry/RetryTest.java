package study.httpclient.client.retry;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

@Slf4j
public class RetryTest {

    private static final String URL = "https://www.abc.cn/";

    @Test
    public void test() throws Exception {
        HttpClient client = HttpClients.custom()
                .setRetryHandler(new CustomRetryHandler())
                .build();
        HttpGet httpGet = new HttpGet(URL);
        HttpResponse response = client.execute(httpGet);
        StatusLine line = response.getStatusLine();
        log.info("{}", line);
    }
}
