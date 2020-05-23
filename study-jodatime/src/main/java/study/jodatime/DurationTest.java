package study.jodatime;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.junit.Test;

public class DurationTest {

    @Test
    public void test() {

        //2天12小时后过期
//        Period period = new Period()
//                .withMillis(10000000);
//        System.out.println(period.toStandardDays().toPeriod());
//        System.out.println(period.getDays()+"="+period.getHours());

        String str1 = "2020-01-25";
        String str2 = "2020-01-15";
        System.out.println(str1.compareTo(str2));
    }
}
