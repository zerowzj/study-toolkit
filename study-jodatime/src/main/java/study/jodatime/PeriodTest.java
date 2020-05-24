package study.jodatime;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Test;

@Slf4j
public class PeriodTest {

    @Test
    public void test() {
        DateTime start = new DateTime(2016, 8, 18, 10, 3);
        DateTime end = new DateTime(2016, 8, 18, 10, 55);
        Period period = new Period(start, end);
        log.info("{}月{}天{}小时{}分{}秒{}毫秒", period.getMonths(), period.getDays(),
                period.getHours(), period.getMinutes(), period.getSeconds(), period.getMillis());
    }
}
