package study.json.fastjson;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.json.Files;

/**
 * （★）解析Json对象，获取对象中的值，通常是使用类中的get()方法
 */
@Slf4j
public class JSONObject_Test {

    /**
     * （▲）getXXX()
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

    @Test
    public void getJSONArray_test() {
        String text = Files.read("object.json");
        JSONObject jsonObj = JSONObject.parseObject(text);
        jsonObj.getJSONArray("");
    }
}
