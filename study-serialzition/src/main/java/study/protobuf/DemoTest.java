package study.protobuf;

import com.ynt.ai.activemq.protobuf.PersonModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DemoTest {

    @Test
    public void test() {
        PersonModel.Person person = PersonModel.Person.newBuilder()
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
