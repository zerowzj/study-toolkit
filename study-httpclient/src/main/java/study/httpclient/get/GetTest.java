package study.httpclient.get;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

@Slf4j
public class GetTest {

    private static final String URL = "http://www.sohu.com";

    @Test
    public void test() throws Exception {
        //
        URIBuilder builder = new URIBuilder(URL);
        String query = "name=wangzhj&age=36";
        builder.setCustomQuery(query);
        log.info(builder.toString());

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(builder.build());
        HttpResponse response = client.execute(httpGet);
        StatusLine line = response.getStatusLine();
        log.info("{}", line);

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(null);
    }
}
