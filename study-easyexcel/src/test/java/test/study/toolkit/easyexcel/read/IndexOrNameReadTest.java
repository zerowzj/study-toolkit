package test.study.toolkit.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Before;
import org.junit.Test;
import study.toolkit.easyexcel.TestDataUtils;
import study.toolkit.easyexcel.read.IndexOrNameDataListener;
import study.toolkit.easyexcel.read.SimpleData;
import study.toolkit.easyexcel.read.IndexOrNameData;
import study.toolkit.easyexcel.read.SimpleDataListener;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 指定列的下标或者列名
 * 1. 创建excel对应的实体对象,并使用{@link ExcelProperty}注解. 参照{@link IndexOrNameData}
 * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link IndexOrNameDataListener}
 * 3. 直接读即可
 */
public class IndexOrNameReadTest {


    @Test
    public void simpleReadV1_test() {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(TestDataUtils.getStream("IndexOrName.xlsx"), IndexOrNameData.class, new IndexOrNameDataListener()).sheet().doRead();
    }
}
