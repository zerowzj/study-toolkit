package study.toolkit.easyexcel.write;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderInfo {
    @ExcelProperty({"总标题", "日期标题"})
    private String orderNo;
}
