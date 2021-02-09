package study.toolkit.easyexcel.read.index_name;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IndexOrNameDataListener extends AnalysisEventListener<IndexOrNameData> {

    public void invoke(IndexOrNameData data,
                       AnalysisContext context) {
        log.info(">>>>>> {}", data);
    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }
}
