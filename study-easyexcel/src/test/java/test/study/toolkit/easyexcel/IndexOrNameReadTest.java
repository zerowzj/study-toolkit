package test.study.toolkit.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import study.toolkit.easyexcel.TestDataUtils;
import study.toolkit.easyexcel.read.index_name.IndexOrNameData;
import study.toolkit.easyexcel.read.index_name.IndexOrNameDataListener;

/**
 * 指定列的下标或者列名
 * 1.创建excel对应的实体对象,并使用 ExcelProperty 注解
 * 2.由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器
 * 3.直接读即可
 */
public class IndexOrNameReadTest {

    private String file = "IndexOrName.xlsx";

    @Test
    public void simpleReadV1_test() {
        EasyExcel.read(TestDataUtils.getStream(file), IndexOrNameData.class, new IndexOrNameDataListener())
                .sheet()
                .doRead();
    }
}
