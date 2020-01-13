package study.httpclient.client.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UrlEncodedFormEntityTest {

    private String url = "";

    @Test
    public void test() throws IOException {
        List<BasicNameValuePair> paramLt = new ArrayList();
        paramLt.add(new BasicNameValuePair("name", "wangzhj"));
        paramLt.add(new BasicNameValuePair("age", "38"));
        //构造Entity
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramLt);
//        entity.setContentType("");
//        entity.setContentEncoding("");
//        entity.setChunked(false);
        log.info(EntityUtils.toString(formEntity));
        //设置Entity
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(formEntity);

        CloseableHttpClient client = HttpClients.createDefault();
        client.execute(httpPost);
    }
}
