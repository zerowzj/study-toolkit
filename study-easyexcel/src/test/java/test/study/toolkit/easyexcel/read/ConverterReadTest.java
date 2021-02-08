package test.study.toolkit.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import study.toolkit.easyexcel.TestDataUtils;
import study.toolkit.easyexcel.read.converter.ConverterData;
import study.toolkit.easyexcel.read.converter.ConverterDataListener;

/**
 * 日期、数字或者自定义格式转换
 * 默认读的转换器 DefaultConverterLoader#loadDefaultReadConverter()
 * 1.创建excel对应的实体对象 参照{@link ConverterData}.里面可以使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
 * 2.由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器
 * 3.直接读即可
 */
public class ConverterReadTest {

    private String file = "";

    @Test
    public void simpleReadV1_test() {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(TestDataUtils.getStream(file), ConverterData.class, new ConverterDataListener())
                // 这里注意 我们也可以registerConverter来指定自定义转换器， 但是这个转换变成全局了，
                // 所有java为string,excel为string的都会用这个转换器。
                // 如果就想单个字段使用请使用@ExcelProperty 指定converter
                // .registerConverter(new CustomStringStringConverter())
                .sheet()
                .doRead();
    }
}
