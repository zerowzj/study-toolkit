package study.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Test;

public class PeriodTest {

    @Test
    public void test() {
        DateTime start = new DateTime(2016, 8, 18, 10, 58);
        DateTime end = new DateTime(2016, 8, 18, 12, 3);
        Period period = new Period(start, end);
        System.out.println(period.getMonths() + "月" + period.getDays() + "天"
                + period.getHours() + "小时" + period.getMinutes() + "分");
    }
}
