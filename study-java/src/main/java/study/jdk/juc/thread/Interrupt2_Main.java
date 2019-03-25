package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.io.File;

/**
 * 这里新建了一个磁盘文件扫描的任务，扫描某个目录下的所有文件并将文件路径打印到控制台，扫描的过程可能会很长。
 * 若需要中止该任务，只需在控制台键入quit并回车即可
 */
public class Interrupt2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Interrupt2_Main.class);

    Thread t;

    public void listFile(File file) throws InterruptedException {
        if (file == null) {
            throw new IllegalArgumentException();
        }
        if (file.isFile() && !file.isHidden()) {
            LOGGER.info("file: {}", file.getName());
            return;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException("文件扫描任务被中断");
        }
        LOGGER.info("{}", file.getName());
        File[] files = file.listFiles();
        for (File f : files) {
            LOGGER.info("sleep 2s");
            Sleeps.seconds(2);
            listFile(f);
        }
    }

    public void test() {
        t = new Thread(() -> {
            try {
                listFile(new File("d:\\"));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        new Interrupt2_Main().test();
        Sleeps.seconds(1100000000);
    }
}
