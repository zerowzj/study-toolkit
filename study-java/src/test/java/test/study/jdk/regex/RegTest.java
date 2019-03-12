package test.study.jdk.regex;

import org.junit.Test;

import java.util.regex.Pattern;

public class RegTest {

    @Test
    public void _test1(){
        Pattern p = Pattern.compile("&#([a-zA-Z]{4}|[0-9]{4})");
        System.out.println(p.matcher("&#6441").find());
        System.out.println(p.matcher("&#abcd").find());
        System.out.println(p.matcher("&#12cd").find());
    }

    @Test
    public void _test(){
        Pattern p = Pattern.compile("&#(x[0-9a-zA-Z]{4}|[0-9]+)");
        System.out.println(p.matcher("<p>&#x6441;&#x6C0;&#x96F;&#x4E0;8&#x5EA;</p>").find());
    }
}
