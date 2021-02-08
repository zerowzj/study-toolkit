package study.toolkit.easyexcel.read.index_name;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class IndexOrNameData {

    //强制读取第三个 这里不建议 index_name 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
    @ExcelProperty(index = 3)
    private Double amount;
    //用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
    @ExcelProperty("姓名")
    private String userName;
    @ExcelProperty("生日")
    private Date birthday;
}
