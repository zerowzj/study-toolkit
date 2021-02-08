package study.toolkit.easyexcel.read.simple;

import com.alibaba.excel.annotation.ExcelIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class SimpleData {

    private String string;

    private Date date;

    private Double doubleData;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
