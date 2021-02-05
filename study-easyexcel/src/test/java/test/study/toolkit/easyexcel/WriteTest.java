package test.study.toolkit.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import study.toolkit.easyexcel.write.OrderInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WriteTest {

    @Test
    public void test() {
        File file = new File("d:\\test.xls");
        EasyExcel.write(file, OrderInfo.class)
                .sheet("sheet1")
                .doWrite(makeOrderLt());
    }

    List<OrderInfo> makeOrderLt() {
        List<OrderInfo> dataLt = new ArrayList<OrderInfo>();
        for (int i = 0; i < 10; i++) {
            OrderInfo info = new OrderInfo();
            info.setOrderNo(String.valueOf(i));

            dataLt.add(info);
        }
        return dataLt;
    }
}
