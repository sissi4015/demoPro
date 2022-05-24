package com.sis.multithreading.A.challenges.contextSwitch;

/**
 * @ClassName: ContextSwitch
 * @Description: 上下文切换
 *              通过循环count次，每次加5，观察并行和串行所用时间，证明上下文切换会影响多线程效率
 * @Author: Sissi
 * @Date: 2022/5/19 11:34
 * @Version: 1.0
 */
public class ContextSwitch {

    //IMPORTANT:通过改变循环次数，比较并行和串行的效率
    private static final long count = 10001;//并行慢
//    private static final long count = 100001;//并行慢
//    private static final long count = 1000001;//差不多
//    private static final long count = 10000001;//并行快
//    private static final long count = 100000001;//并行快1倍

    /**
     * @description: 并行：循环100001次，每次+5
     * @author: Sissi
     * @date: 2022/5/19 11:52
     */
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency: " + time + "ms");
    }

    /**
     * @description: 串行：循环100001次，每次+5
     * @author: Sissi
     * @date: 2022/5/19 11:53
     */
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + "ms" + ", a = " + a);
    }

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

}
