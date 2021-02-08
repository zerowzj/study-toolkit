package test.study.toolkit.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;
import study.toolkit.easyexcel.TestDataUtils;
import study.toolkit.easyexcel.read.simple.SimpleData;
import study.toolkit.easyexcel.read.simple.SimpleDataListener;

/**
 * 最简单的读
 * 1.创建excel对应的实体对象
 * 2.由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器
 * 3.直接读即可
 */
public class SimpleReadTest {

    private String file = "Simple.xlsx";

    @Test
    public void simpleReadV1_test() {
        //这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(TestDataUtils.getStream(file), SimpleData.class, new SimpleDataListener())
                .sheet()
                .doRead();
    }

    @Test
    public void simpleReadV2_test() {
        ExcelReader reader = null;
        try {
            //Step-1: create reader
            reader = EasyExcel.read(TestDataUtils.getStream(file), SimpleData.class, new SimpleDataListener())
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
