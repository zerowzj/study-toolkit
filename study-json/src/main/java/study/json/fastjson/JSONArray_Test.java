package study.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * （★）JSON对象数组，通常是通过迭代器取得其中的JSONObject，再利用JSONObject的get()方法进行取值
 */
@Slf4j
public class JSONArray_Test {

    /**
     * （▲）getXXX()
     */
    @Test
    public void parseObject_test() {
        String text = "{'id':1,'name':'wangzhj'}";
        JSONArray jsonArr = JSON.parseArray(text);
        jsonArr.forEach(jsonObj -> {
        });
    }
}
