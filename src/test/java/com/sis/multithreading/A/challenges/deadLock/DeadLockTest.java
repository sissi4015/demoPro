package com.sis.multithreading.A.challenges.deadLock;

/**
 * @ClassName: DeadLockTest
 * @Description: 示例代码-死锁是怎么造成的
 * @Author: Sissi
 * @Date: 2022/5/19 13:08
 * @Version: 1.0
 */
public class DeadLockTest {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockTest().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }


}
