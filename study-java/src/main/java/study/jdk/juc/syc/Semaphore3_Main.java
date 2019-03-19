package study.jdk.juc.syc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Loggers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 演示：20个人去银行存款，但是该银行只有两个办公柜台，有空位则上去存钱，没有空位则只能去排队等待
 */
public class Semaphore3_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Semaphore3_Main.class);

    private static final int NUM = 5;

    public static void main(String[] args) {
        Bank bank = new Bank();
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < NUM; i++) {
            User user = new User(String.format("%s", i + 1), bank);
            new Thread(new SaveMoney(user, semaphore)).start();
        }
    }
}


/**
 * 银行
 */
class Bank {

    private int account = 0;

    public int getAccount() {
        return account;
    }

    public void save(int money) {
        account += money;
    }
}

/**
 * 存钱
 */
class SaveMoney implements Runnable {

    private User user;

    private Semaphore semaphore;

    public SaveMoney(User user, Semaphore semaphore) {
        this.user = user;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        if (semaphore.availablePermits() > 0) {
            Loggers.info("用户[{}]进入银行，有位置，立即去存钱", user.getName());
        } else {
            Loggers.info("用户[{}]进入银行，无位置，去排队等待", user.getName());
        }
        try {
            semaphore.acquire();
            user.saveMoney(10);
//            TimeUnit.SECONDS.sleep(5);
            Thread.sleep(1000);
            Loggers.info("用户[{}]存钱完毕，离开银行", user.getName());
        } catch (InterruptedException ex) {
        } finally {
            semaphore.release(1);
        }
    }
}

/**
 * 用户
 */
class User {

    private String name;

    private Bank bank;

    public User(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    public void saveMoney(int money) {
        bank.save(money);
        Loggers.info("用户[{}]存款后，银行金额为：{}", name, bank.getAccount());
    }

    public String getName() {
        return name;
    }
}
