package study.toolkit.easyexcel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.每解析一行会回调 invoke() 方法
 * 2.整个 excel 解析结束会执行 doAfterAllAnalysed() 方法
 * 3.Spring中的组件，推荐两种方法注入
 * （1）提供一个UserInfoDataListener的构造方法，这个方法提供一个参数是UserInfoDataListener类型
 * （2）另外一种方法就是将 UserInfoDataListener 这个类定义成 UserService 实现类的内部类（推荐这种方式）
 */
@Slf4j
public class DemoDataListener extends AnalysisEventListener<DemoData> {

    private static final int BATCH_COUNT = 100;

    private List<DemoData> userInfoLt = new ArrayList<DemoData>();

    public void invoke(DemoData userInfo, AnalysisContext context) {
        log.info(">>>>>> {}", userInfo);
        userInfoLt.add(userInfo);
        if (userInfoLt.size() >= BATCH_COUNT) {
//            saveData();
            // 存储完成清理 list
            userInfoLt.clear();
        }
    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
//        saveData();
        log.info("所有数据解析完成！");
    }
}
