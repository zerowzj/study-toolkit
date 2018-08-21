package study.algorithm;

import org.junit.Test;

public class Test1 {

    int[] arr = {2, 5, 4, 7, 1, 3, 10};

    int len = arr.length;

    @Test
    public void test() {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}
