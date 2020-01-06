package study.json;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;

@Slf4j
public class Files {

    private static final String DIR = "json";

    private static final String SUFFIX = ".json";

    public static String read(String fileName) {
        ClassLoader classLoader = Files.class.getClassLoader();
        /**
         getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
         */
        URL url = classLoader.getResource(fileName);
        return null;
    }

    public static void main(String[] args) {
        // classpath目录下
        URL resource = Files.class.getResource("/");
        log.info(resource.toString());
        // classpath+该类所在路径
        URL resource1 = Files.class.getResource("");
        log.info(resource1.toString());

        // classpath目录下
        URL resource2 = Files.class.getClassLoader().getResource("");
        log.info(resource2.toString());
        // null
        URL resource3 = Files.class.getClassLoader().getResource("/");
        log.info(resource3.toString());
    }
}
