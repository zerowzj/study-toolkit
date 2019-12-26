package study.httpclient.post;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

@Slf4j
public class PostTest {

    private static final String URL = "http://www.sohu.com";

    @Test
    public void test() throws Exception {
        HttpPost httpPost = new HttpPost(URL);
        //请求实体
        StringEntity entity = new StringEntity("12312312");
//        httpPost.setEntity(entity);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpPost);
        StatusLine line = response.getStatusLine();
        log.info("{}", line);
    }
}
