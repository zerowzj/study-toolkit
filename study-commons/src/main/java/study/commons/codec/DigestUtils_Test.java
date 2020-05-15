package study.commons.codec;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class DigestUtils_Test {

    private static final String STR = "26803BDCD00D41CFA94BBD450E8E58F4" + System.currentTimeMillis();

    @Test
    public void md5_test() {
        //DigestUtils.md5("");
        String str = DigestUtils.md5Hex(STR);
        log.info("{}", str);
    }

    @Test
    public void sha1_test() {
        String str = DigestUtils.sha1Hex("abc123");
        log.info("{}", str);
    }

    /**
     * SHA1
     */
    @Test
    public void sha2_test() {
        //DigestUtils.sha1("");
        String str = DigestUtils.sha256Hex(STR);
        log.info("{}", str);
    }


    @Test
    public void test(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
         list= list.subList(0,Double.valueOf(Math.ceil(list.size()/2d)).intValue());
        log.info(Arrays.toString(list.toArray()));
    }
}
