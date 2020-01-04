package study.apache.commons.lang3.reflect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

@Slf4j
public class FieldUtils_Test {

    /**
     *
     */
    @Test
    public void getAllFields_test() {
        Field[] fields = FieldUtils.getAllFields(Son.class);
        for (Field field : fields) {
            log.info(field.getName());
        }
        List<Field> fieldLt = FieldUtils.getAllFieldsList(Son.class);
        fieldLt.forEach(field -> {
            log.info(field.getName());
        });
    }

    @Test
    public void getFieldsWithAnnotation_test() {
        Field[] fields = FieldUtils.getFieldsWithAnnotation(Son.class, Deprecated.class);
        for (Field field : fields) {
            log.info(field.getName());
        }
        List<Field> fieldLt = FieldUtils.getFieldsListWithAnnotation(Son.class, Deprecated.class);
        fieldLt.forEach(field -> {
            log.info(field.getName());
        });
    }
}
