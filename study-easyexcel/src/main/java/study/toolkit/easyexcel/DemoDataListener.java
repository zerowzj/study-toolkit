package study.toolkit.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoDataListener extends AnalysisEventListener<DemoData> {

    /**
     * 这个每一条数据解析都会来调用
     */
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {

    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
