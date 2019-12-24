package study.guava.base;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class StopwatchTest {

    @Test
    public void test() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(5);
        log.info("{}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
