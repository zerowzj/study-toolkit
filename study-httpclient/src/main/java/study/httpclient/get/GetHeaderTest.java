package study.httpclient.get;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

@Slf4j
public class GetHeaderTest {

    private static final String URL = "http://www.sohu.com";

    @Test
    public void test() throws Exception {
        //
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setHeader("Content-Type", "");

        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);
        StatusLine line = response.getStatusLine();
        log.info("{}", line);
    }
}
