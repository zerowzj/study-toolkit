package study.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.json.Files;

/**
 * （★）主要是实现json对象，json对象数组，javabean对象，json字符串之间的相互转化
 */
@Slf4j
public class JSON_Test {

    /**
     * （▲）String ==> Json
     */
    @Test
    public void parse_test() {
        String text = Files.read("array.json");
        Object obj = JSON.parse(text);
        log.info("{}", obj);
    }

    @Test
    public void parseObject_test() {
        String text = Files.read("object.json");
        JSONObject obj = JSON.parseObject(text);
        log.info(obj.getString("name"));
    }

    @Test
    public void parseArray_test() {
        String text = Files.read("array.json");
        JSONArray array = JSON.parseArray(text);
        array.forEach(obj -> {
            log.info("{}", obj);
        });
    }

    /**
     * （▲）Json ==> String
     */
    @Test
    public void toJSONString_test() {
        String text = Files.read("array.json");
        String json = JSON.toJSONString(text);
        log.info("{}", json);
    }

    /**
     * （▲）
     */
    @Test
    public void isValid_test() {
        String jsonStr = Files.read("object.json");
        boolean isJson = JSON.isValid(jsonStr);
        log.info("{}", isJson);
    }

    @Test
    public void isValidObject_test() {
        String jsonStr = Files.read("object.json");
        boolean isJson = JSON.isValidObject(jsonStr);
        log.info("{}", isJson);
    }

    @Test
    public void isValidArray_test() {
        String jsonStr = Files.read("object.json");
        boolean isJson = JSON.isValidArray(jsonStr);
        log.info("{}", isJson);
    }
}
