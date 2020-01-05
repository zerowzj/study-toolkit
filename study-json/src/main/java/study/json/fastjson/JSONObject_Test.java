package study.json.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class JSONObject_Test {

    @Test
    public void parseObject_test() {
        String text = "{'id':1,'name':'wangzhj'}";
        JSONObject jsonObj = JSONObject.parseObject(text);
        log.info(jsonObj.getString("name"));
    }

    @Test
    public void parse_test() {
        String text = "[{'id':1,'name':'wangzhj'}, {'id':1,'name':'zerowzj'}]";
        Object obj = JSONObject.parse(text);
        log.info("{}", obj);
    }
}
