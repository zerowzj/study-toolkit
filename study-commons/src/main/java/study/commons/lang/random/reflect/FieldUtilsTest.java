package study.commons.lang.random.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

import java.lang.reflect.Field;

public class FieldUtilsTest {

    //获取所有Field，包括父类
    @Test
    public void getAllFields_test() {
        Field[] fields = FieldUtils.getAllFields(Son.class);
        for (Field field : fields) {
            System.out.println(field.getName());
        }

    }

    //
    @Test
    public void getFieldsWithAnnotation_test() {
        Field[] fields = FieldUtils.getFieldsWithAnnotation(Son.class, null);
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
