package test.study.toolkit.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Before;
import org.junit.Test;
import study.toolkit.easyexcel.read.DemoData;
import study.toolkit.easyexcel.read.DemoDataListener;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 最简单的读
 * 1. 创建excel对应的实体对象 参照{@link DemoData}
 * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
 * 3. 直接读即可
 */
public class SimpleReadTest {

    private InputStream fs;

    private AnalysisEventListener listener = new DemoDataListener();

    @Before
    public void init() {
        try {
            fs = new FileInputStream("D:\\idea\\study\\study-toolkit\\study-easyexcel\\src\\main\\resources\\excel\\UserInfo.xlsx");
        } catch (Exception ex) {

        }
    }

    @Test
    public void simpleReadV1_test() {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fs, DemoData.class, listener).sheet().doRead();
    }

    @Test
    public void simpleReadV2_test() throws Exception {
        ExcelReader reader = null;
        try {
            //Step-1: create reader
            reader = EasyExcel.read(fs, DemoData.class, listener)
                    .build();
            //Step-2: create sheet
            ReadSheet sheet1 = EasyExcel.readSheet(0).build();
            ReadSheet sheet2 = EasyExcel.readSheet(1).build();
            //Step-3: read the sheet
            reader.read(sheet1, sheet2);
        } catch (Exception ex) {

        } finally {
            // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
            if (reader != null) {
                reader.finish();
            }
        }
    }
}
