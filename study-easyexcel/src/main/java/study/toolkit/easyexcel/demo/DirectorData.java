package study.toolkit.easyexcel.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DirectorData {

    @ExcelProperty(index = 0)
    private String email;
    @ExcelProperty(index = 1)
    private String userName;
    @ExcelProperty(index = 2)
    private String userCode;
}
