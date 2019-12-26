package study.httpclient.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UrlEncodedFormEntityTest {

    @Test
    public void test() throws IOException {
        List<BasicNameValuePair> paramLt = new ArrayList();
        paramLt.add(new BasicNameValuePair("name", "wangzhj"));
        paramLt.add(new BasicNameValuePair("age", "38"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramLt);
        log.info(EntityUtils.toString(entity));
    }
}
