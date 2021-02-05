package test.study.toolkit.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import study.toolkit.easyexcel.write.OrderInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SimpleWriteTest {

    @Test
    public void simpleWriteV1_test() {
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }

    @Test
    public void simpleWriteV2_test() {
        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter writer = null;
        try {
            writer = EasyExcel.write(fileName, DemoData.class).build();
            WriteSheet sheet = EasyExcel.writerSheet("模板").build();
            writer.write(data(), sheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (writer != null) {
                writer.finish();
            }
        }
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
