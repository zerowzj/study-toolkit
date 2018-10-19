package study.jdk.juc.lock;

public class UnLockMain implements Runnable {

    private UnLock unlock = new UnLock();

    public void get() {
        try {
            unlock.lock();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(Thread.currentThread().getId());
        set();
        unlock.unlock();
    }

    public void set() {
        try {
            unlock.lock();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
        unlock.unlock();
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        UnLockMain ss = new UnLockMain();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        System.out.println("sdfdsfdsf");
        System.out.println("adsfasdf");
    }
}
