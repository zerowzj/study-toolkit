package study.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.json.Files;

@Slf4j
public class JSONObject_Test {

    /**
     * （★）String -> Json
     */
    @Test
    public void parse_test() {
        String text = Files.read("array.json");
        Object obj = JSONObject.parse(text);
        log.info("{}", obj);
    }

    @Test
    public void parseObject_test() {
        String text = Files.read("object.json");
        JSONObject obj = JSONObject.parseObject(text);
        log.info(obj.getString("name"));
    }

    @Test
    public void parseArray_test() {
        String text = Files.read("array.json");
        JSONArray array = JSONObject.parseArray(text);
        array.forEach(obj -> {
            log.info("{}", obj);
        });
    }

    /**
     * （★）Json -> String
     */
    @Test
    public void toJSONString_Test() {
        String text = Files.read("array.json");
        String json = JSONObject.toJSONString(text);
        log.info("{}", json);
    }

    /**
     * （★）
     */
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
