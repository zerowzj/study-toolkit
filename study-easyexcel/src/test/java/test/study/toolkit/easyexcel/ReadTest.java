package test.study.toolkit.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;
import study.toolkit.easyexcel.read.UserInfo;
import study.toolkit.easyexcel.read.UserInfoListener;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadTest {

    @Test
    public void simpleRead_test() throws Exception {
        InputStream fs = new FileInputStream("D:\\idea\\study\\study-toolkit\\study-easyexcel\\src\\main\\resources\\excel\\UserInfo.xlsx");
        AnalysisEventListener listener = new UserInfoListener();

        //Step-1: create reader
        ExcelReader reader = EasyExcel.read(fs, UserInfo.class, listener)
                .build();
        //Step-2: create sheet
        ReadSheet sheet1 = EasyExcel.readSheet(0).build();
        ReadSheet sheet2 = EasyExcel.readSheet(1).build();
        //Step-3: read the sheet
        reader.read(sheet1);

        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        if (reader != null) {
            reader.finish();
        }
    }
}
