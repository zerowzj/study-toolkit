package study.httpclient.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.junit.Test;

@Slf4j
public class MultipartEntityBuilderTest {

    @Test
    public void test() {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addBinaryBody()
//        builder.addTextBody()
        HttpEntity entity = builder.build();
    }
}
