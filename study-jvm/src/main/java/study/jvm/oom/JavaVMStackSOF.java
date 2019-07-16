package study.jvm.oom;

/**
 * -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable ex) {
            System.out.println("stack length: " + sof.stackLength);
            throw ex;
        }
    }
}
