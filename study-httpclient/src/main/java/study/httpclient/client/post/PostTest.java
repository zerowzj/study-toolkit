package study.httpclient.client.post;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

@Slf4j
public class PostTest {

    private String url = "http://www.sohu.com";

    @Test
    public void test() throws Exception {
        HttpPost httpPost = new HttpPost(url);
        //请求实体
        StringEntity strEntity = new StringEntity("12312312");
        httpPost.setEntity(strEntity);
        //请求
        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpPost);
        //响应
        StatusLine statusLine = response.getStatusLine();
        log.info("status line: {}", statusLine);
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        log.info("entity: {}", body);
    }
}
