package study.json.fastjson;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.json.Files;

/**
 * 解析Json对象，获取对象中的值，通常是使用类中的get()方法
 */
@Slf4j
public class JSONObject_Test {

    /**
     * （★）getXXX()
     */
    @Test
    public void getString_test() {
        String text = Files.read("object.json");
        JSONObject jsonObj = JSONObject.parseObject(text);
        log.info(jsonObj.getString("name"));
    }

    @Test
    public void getJSONObject_test() {
        String text = Files.read("object.json");
        JSONObject jsonObj = JSONObject.parseObject(text);
        jsonObj.getJSONObject("");
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
