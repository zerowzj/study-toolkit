package study.json.fastjson;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.json.Files;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JSONObject_Test {

    @Test
    public void parseObject_test() {
        String text = Files.read("object.json");
        JSONObject jsonObj = JSONObject.parseObject(text);
        log.info(jsonObj.getString("name"));
    }

    @Test
    public void parse_test() {
        String text = Files.read("array.json");
        Object obj = JSONObject.parse(text);
        log.info("{}", obj);
    }

    @Test
    public void parse1_test() {
        Map data = new HashMap<>();
        data.put("name", "123");
        Object jsonStr = JSONObject.toJSON(data);
        log.info("{}", jsonStr);
    }

    @Test
    public void isValid_test() {
        String jsonStr = Files.read("object.json");
        boolean isJson = JSONObject.isValid(jsonStr);
        log.info("{}", isJson);
    }

    @Test
    public void isValidObject_test() {
        String jsonStr = Files.read("object.json");
        boolean isJson = JSONObject.isValidObject(jsonStr);
        log.info("{}", isJson);
    }

    @Test
    public void isValidArray_test() {
        String jsonStr = Files.read("object.json");
        boolean isJson = JSONObject.isValidArray(jsonStr);
        log.info("{}", isJson);
    }
}
