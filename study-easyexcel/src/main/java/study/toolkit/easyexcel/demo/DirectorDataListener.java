package study.toolkit.easyexcel.demo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DirectorDataListener extends AnalysisEventListener<DirectorData> {

    private static final int BATCH_COUNT = 100;

    private List<DirectorData> dataLt = new ArrayList<DirectorData>();

    public void invoke(DirectorData data, AnalysisContext context) {
        log.info(">>>>>> {}", data);
        dataLt.add(data);
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
