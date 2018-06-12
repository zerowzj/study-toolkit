package study.guava.primitive;

import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LongsTest {

    //List<Long> asList(long... backingArray)
    @Test
    public void asList_test() {
        //
        List<Long> longLt = Longs.asList(1, 2);

        Arrays.asList(1, 2);
    }

    //toArray
    @Test
    public void toArray_test() {
        //
        List<Long> longLt = Arrays.asList(1L, 2L);
        long[] longs = Longs.toArray(longLt);
    }

    //long[] concat(long[]...)
    @Test
    public void concat_test() {
        long[] longs = Longs.toArray(Longs.asList(1, 2));
        longs = Longs.concat(longs, Longs.toArray(Longs.asList(3, 4)));
        System.out.println(longs);
    }

    //byte[] = toByteArray(long)
    @Test
    public void toByteArray_test() {

        short value1 = 100;
        byte[] bytes1 = Shorts.toByteArray(value1);
        System.out.println(bytes1.length);

        int value2 = 100;
        byte[] bytes2 = Ints.toByteArray(value2);
        System.out.println(bytes2.length);

        long value3 = 100;
        byte[] bytes3 = Longs.toByteArray(value3);
        System.out.println(bytes3.length);
    }


    //concat
    @Test
    public void fromByteArray_test() {
        long value = 100;
    }
}
