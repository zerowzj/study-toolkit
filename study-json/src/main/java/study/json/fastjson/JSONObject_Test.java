package study.json.fastjson;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import study.json.Files;

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
}
