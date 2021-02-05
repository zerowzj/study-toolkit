package study.toolkit.easyexcel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserInfoDataListener extends AnalysisEventListener<UserInfo> {

    public void invoke(UserInfo userInfo, AnalysisContext context) {
        log.info(">>>>>> {}", userInfo);
    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }
}
