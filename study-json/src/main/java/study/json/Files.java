package study.json;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Slf4j
public class Files {

    private static final String DIR = "json/";

    public static String read(String fileName) {
        ClassLoader classLoader = Files.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream(DIR + fileName);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
        StringBuffer sb = new StringBuffer();
        String str;
        try {
            while ((str = buffer.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

    @Test
    public void test() {
        //classpath目录下
        URL res = Files.class.getResource("/");
        log.info(res.toString());
        //classpath + 该类所在路径
        res = Files.class.getResource("");
        log.info(res.toString());

    }

    @Test
    public void classLoader_test() {
        //classpath目录下
        URL res = Files.class.getClassLoader().getResource("");
        log.info(res.toString());
        //null
        res = Files.class.getClassLoader().getResource("/");
        log.info(res.toString());
    }
}
