package study.apache.commons.codec;

import org.apache.commons.codec.net.URLCodec;
import org.junit.Before;
import org.junit.Test;

public class URLCodecTest {

    String str = "你好abc";

    URLCodec codec;

    @Before
    public void before() {
        codec = new URLCodec();
    }

    @Test
    public void md5_test() throws Exception {
        String s = codec.encode(str);
        System.out.println(s);
    }
    @Test
    public void md15_test() throws Exception {
        String s = codec.decode("JSESSIONID=ACDBCCD74529306DEE57F09AE7D2D1F8; UM_distinctid=1609a50e2e31-042f53a7db484e-440a5a33-38400-1609a50e2e552; CNZZDATA1260761932=1665658620-1501468470-https%253A%252F%252Fenterbj.zhongchebaolian.com%252F%7C1516609759");
        System.out.println(s);
    }
}
