package study.guava.primitive;

import com.google.common.primitives.Ints;
import org.junit.Test;

public class IntsTest {

    public static void main(String[] args) {
        int i = Ints.tryParse("01");
        System.out.println(i);
    }
}
