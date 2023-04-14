package yc.runoob;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class threadDemo3 implements Callable<Integer> {

    @Override
    public Integer call() {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println("13L：" + Thread.currentThread().getName() + " " + i);
        }
        return i;
    }

    public static void main(String[] args) {
        threadDemo3 ctt = new threadDemo3();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 2; i++) {
            System.out.println("22L：" + Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 1) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("28L：" + "子线程的返回值：" + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}