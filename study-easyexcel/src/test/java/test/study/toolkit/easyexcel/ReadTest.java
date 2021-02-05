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
        InputStream fis = new FileInputStream("D:\\idea\\study\\study-toolkit\\study-easyexcel\\src\\main\\resources\\excel\\UserInfo.xlsx");
        AnalysisEventListener listener = new UserInfoListener();
        ExcelReader excelReader = EasyExcel.read(fis, UserInfo.class, listener)
                .build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        ReadSheet readSheet2 = EasyExcel.readSheet(1).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }
}
