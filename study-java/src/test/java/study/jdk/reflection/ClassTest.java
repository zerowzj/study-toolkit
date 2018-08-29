package study.jdk.reflection;

import org.junit.Test;

public class ClassTest {

    private int i = 1;
    private Integer ii = 1;
    private String str = "";
    private String[] strArr = new String[]{"a", "bc"};

    @Test
    public void isArray_test() {
        System.out.println(ii.getClass().isArray());
        System.out.println(strArr.getClass().isArray());
    }

    @Test
    public void getComponentType_test() {
        System.out.println(ii.getClass().getComponentType().getName());
        System.out.println(strArr.getClass().getComponentType().getName());
    }
}
