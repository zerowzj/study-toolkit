package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 演示：线程池执行有返回值的任务
 * （1）任务独立，无临界区
 */
public class FixedThreadPool3_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedThreadPool3_Main.class);

    private static final int THREAD_NUM = 3;

    private static final int TASK_NUM = 10;

    /**
     * 任务
     */
    private class Task implements Callable<Result> {

        private String taskNo;

        private int value;

        public Task(String taskNo, int value) {
            this.taskNo = taskNo;
            this.value = value;
        }

        @Override
        public Result call() throws Exception {
            LOGGER.info("task_no={}, sleep {}s", taskNo, value);
            Sleeps.seconds(value);
            Result result = new Result(taskNo, value);
            return result;
        }
    }

    /**
     * 任务结果
     */
    private class Result implements Serializable {

        private String taskNo;

        private int value;

        public Result(String taskNo, int value) {
            this.taskNo = taskNo;
            this.value = value;
        }

        public String getTaskNo() {
            return taskNo;
        }

        public int getValue() {
            return value;
        }
    }

    private void test() {
        ExecutorService POOL = Executors.newFixedThreadPool(THREAD_NUM);
        //任务异步执行
        List<Future<Result>> futureLt = new ArrayList<>();
        for (int i = 0; i < TASK_NUM; i++) {
            String taskNo = String.valueOf(i + 1);
            int random = Randoms.nextInt(9);
            futureLt.add(POOL.submit(new Task(taskNo, random)));
        }
        //阻塞主线程获取结果
        for (Future<Result> future : futureLt) {
            try {
                Result result = future.get();
                LOGGER.info("task_no={}, begin_time={}, end_time={}", result.taskNo, result.getValue());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FixedThreadPool3_Main().test();
    }
}
