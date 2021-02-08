package test.study.toolkit.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import study.toolkit.easyexcel.TestDataUtils;
import study.toolkit.easyexcel.demo.DirectorData;
import study.toolkit.easyexcel.demo.DirectorDataListener;

public class DirectorReadTest {

    @Test
    public void simpleReadV1_test() {
        EasyExcel.read(TestDataUtils.getStream("Director.xlsx"), DirectorData.class, new DirectorDataListener())
                .sheet()
                .headRowNumber(3)
                .doRead();
    }
}
