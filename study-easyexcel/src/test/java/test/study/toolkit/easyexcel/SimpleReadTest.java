package test.study.toolkit.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Before;
import org.junit.Test;
import study.toolkit.easyexcel.read.UserInfo;
import study.toolkit.easyexcel.read.UserInfoListener;

import java.io.FileInputStream;
import java.io.InputStream;

public class SimpleReadTest {

    private InputStream fs;

    private AnalysisEventListener listener = new UserInfoListener();

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
        EasyExcel.read(fs, UserInfo.class, listener).sheet().doRead();
    }

    @Test
    public void simpleReadV2_test() throws Exception {
        ExcelReader reader = null;
        try {
            //Step-1: create reader
            reader = EasyExcel.read(fs, UserInfo.class, listener)
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
