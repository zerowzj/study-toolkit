package test.study.jvm.oom;

/**
 * Java栈
 * -Xss128K
 */
public class JavaVMStackSOF {

    int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Exception ex){
            System.out.println("stack length" + oom.stackLength);
//            throw ex;
        }
    }
}
