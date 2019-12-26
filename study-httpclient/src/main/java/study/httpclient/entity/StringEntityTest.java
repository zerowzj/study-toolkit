package study.httpclient.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class StringEntityTest {

    @Test
    public void test() throws IOException {
        StringEntity entity = new StringEntity("");
    }
}
