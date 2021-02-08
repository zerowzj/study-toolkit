package study.toolkit.easyexcel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class IndexOrNameDataListener extends AnalysisEventListener<IndexOrNameData> {

    private static final int BATCH_COUNT = 100;

    private List<IndexOrNameData> dataLt = new ArrayList<IndexOrNameData>();

    public void invoke(IndexOrNameData userInfo, AnalysisContext context) {
        log.info(">>>>>> {}", userInfo);
        dataLt.add(userInfo);
        if (dataLt.size() >= BATCH_COUNT) {
//            saveData();
            // 存储完成清理 list
            dataLt.clear();
        }
    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
//        saveData();
        log.info("所有数据解析完成！");
    }
}
