package test.study.toolkit.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;
import study.toolkit.easyexcel.TestDataUtils;
import study.toolkit.easyexcel.read.simple.SimpleData;
import study.toolkit.easyexcel.read.simple.SimpleDataListener;

/**
 * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
 * 1. 创建excel对应的实体对象
 * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器
 * 3. 直接读即可
 */
public class RepeatedReadTest {

    private String file = "Simple.xlsx";

    @Test
    public void readAll_test() {
        // 读取全部sheet
        // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
        EasyExcel.read(TestDataUtils.getStream(file), SimpleData.class, new SimpleDataListener())
                .doReadAll();
    }

    @Test
    public void readPart_test() {
        //读取部分sheet
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(TestDataUtils.getStream(file))
                    .build();
            //这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
            ReadSheet sheet1 = EasyExcel.readSheet(0)
                    .head(SimpleData.class)
                    .registerReadListener(new SimpleDataListener())
                    .build();
            ReadSheet sheet2 = EasyExcel.readSheet(1)
                    .head(SimpleData.class)
                    .registerReadListener(new SimpleDataListener())
                    .build();
            //这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
            excelReader.read(sheet1, sheet2);
        } finally {
            if (excelReader != null) {
                excelReader.finish();
            }
        }
    }
}
