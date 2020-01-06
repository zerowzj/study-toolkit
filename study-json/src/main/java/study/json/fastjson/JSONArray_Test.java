package study.json.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class JSONArray_Test {

    @Test
    public void parseObject_test() {
        String text = "{'id':1,'name':'wangzhj'}";
        JSONObject jsonObj = JSONArray.parseObject(text);
        log.info(jsonObj.getString("name"));
    }
}
