package study.protobuf;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DemoTest {

    @Test
    public void test() {
        DemoOuterClass.Demo person = DemoOuterClass.Demo.newBuilder()
                .setId(2)
                .setName("test")
                .setEmail("test@163.com")
                .build();

        byte[] results = person.toByteArray();
        for (byte b : results) {
            log.info(String.valueOf(b));
        }
    }
}
