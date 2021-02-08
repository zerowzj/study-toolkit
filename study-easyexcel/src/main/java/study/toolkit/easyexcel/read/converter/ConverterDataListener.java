package study.toolkit.easyexcel.read.converter;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConverterDataListener extends AnalysisEventListener<ConverterData> {

    public void invoke(ConverterData data, AnalysisContext context) {
        log.info(">>>>>> {}", data);
    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }
}
