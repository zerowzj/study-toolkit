package study.guava.str;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class StopwatchTest {

    @Test
    public void test() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
