package study.jdk.juc.syc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

/**
 * 演示：20个人去银行存款，但是该银行只有两个办公柜台，有空位则上去存钱，没有空位则只能去排队等待
 */
public class Semaphore3_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Semaphore3_Main.class);

    private static final int NUM = 20;

    public static void main(String[] args) {

        Bank bank = new Bank();
        for (int i = 0; i < 20; i++) {

            new Thread(new SaveMoney(new User())).start();
        }

    }

    class SaveMoney implements Runnable {

        private User user;

        private Bank bank;

        private Semaphore semaphore = new Semaphore(2);

        public SaveMoney(Bank bank, User user) {
            this.bank = bank;
            this.user = user;
        }

        @Override
        public void run() {


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
}