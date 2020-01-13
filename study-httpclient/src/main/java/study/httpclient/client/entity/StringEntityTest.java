package study.httpclient.client.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class StringEntityTest {

    private String url = "";

    @Test
    public void test() throws IOException {
        //构造Entity
        StringEntity strEntity = new StringEntity("沙发斯蒂芬", "UTF-8");
//        strEntity.setContentType("");
//        strEntity.setContentEncoding("");
//        strEntity.setChunked(false);
        log.info(EntityUtils.toString(strEntity, "UTF-8"));
        //设置Entity
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(strEntity);
        CloseableHttpClient client = HttpClients.createDefault();
        client.execute(httpPost);
    }
}
