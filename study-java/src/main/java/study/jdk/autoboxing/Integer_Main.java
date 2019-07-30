package study.jdk.autoboxing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * （1）int和Integer运算时，会进行自动拆箱
 * （2）-128至127之间的数字，使用valueOf()时会有缓存
 * （3）==基本类型时比较值，引用类型比较指针
 */
public class Integer_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Integer_Main.class);

    public static void main(String[] args) {
        Integer i1 = 59;
        int i2 = 59;
        Integer i3 = Integer.valueOf(59);
        Integer i4 = new Integer(59);
        //自动拆箱
        LOGGER.info("(i1==i2): {}", i1 == i2);
        LOGGER.info("(i3==i2): {}", i3 == i2);
        LOGGER.info("(i4==i2): {}", i4 == i2);
        //valueOf
        LOGGER.info("(i1==i3): {}", i1 == i3);
        //==基本类型比较值，引用类型比较指针
        LOGGER.info("(i3==i4): {}", i3 == i4);
    }
}
