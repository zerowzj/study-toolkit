package study.jdk.juc.syc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 演示：N个人去银行存款，但是该银行只有两个办公柜台，有空位则上去存钱，没有空位则只能去排队等待
 */
public class Semaphore4_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Semaphore3_Main.class);

    private static final int NUM = 5;

    /**
     * 银行类
     */
    class Bank {
        private int account = 0;

        public int getAccount() {
            return this.account;
        }

        public void save(int money) {
            this.account += money;
        }
    }

    /**
     * 存钱流程类
     */
    class SaveMoney implements Runnable {

        private Bank bank;

        private Semaphore semaphore;

        public SaveMoney(Bank bank, Semaphore semaphore) {
            this.bank = bank;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            if (semaphore.availablePermits() > 0) {
                LOGGER.info("用户[{}]进入银行，有位置，立即去存钱", Thread.currentThread().getName());
            } else {
                LOGGER.info("用户[{}]进入银行，无位置，去排队等待", Thread.currentThread().getName());
            }
            try {
                semaphore.acquire();
                bank.save(10);
                LOGGER.info("用户[{}]存钱后，银行存款：{}", Thread.currentThread().getName(), bank.getAccount());
                TimeUnit.SECONDS.sleep(5);
                LOGGER.info("用户[{}]存钱完毕，离开银行", Thread.currentThread().getName());
                semaphore.release();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
//                semaphore.release();
            }
        }
    }

    public void test() {
        Bank bank = new Bank();
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < NUM; i++) {
            new Thread(new SaveMoney(bank, semaphore)).start();
        }
//        semaphore.acquireUninterruptibly(2);
//        System.out.println("到点了，工作人员要吃饭了");
//        // 释放两个许可，并将其返回给信号量
//        semaphore.release(2);
    }

    public static void main(String[] args) {
        Semaphore4_Main test = new Semaphore4_Main();
        test.test();
    }
}
