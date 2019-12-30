package study.httpclient.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class StringEntityTest {

    @Test
    public void test() throws IOException {
        //
        StringEntity entity = new StringEntity("沙发斯蒂芬", "UTF-8");
        entity.setContentType("");
        entity.setContentEncoding("");
        entity.setChunked(false);
        log.info(EntityUtils.toString(entity, "UTF-8"));
    }
}
