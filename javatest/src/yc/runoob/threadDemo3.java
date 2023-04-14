package yc.runoob;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//public class threadDemo3 implements Callable<Double> {
//
//    @Override
//    public Double call() {
//        System.out.println("11L：" + Thread.currentThread().getName() + " 在执行call方法");
//        return Math.random();
//    }
//
//    public static void main(String[] args) {
//        threadDemo3 ctt = new threadDemo3();
//        FutureTask<Double> ft = new FutureTask<>(ctt);
//        for (int i = 0; i < 3; i++) {
//            System.out.println("19L：" + Thread.currentThread().getName() + " 的循环变量i的值" + i);
//            new Thread(ft, "线程" + i).start();
//        }
//        try {
//            System.out.println("23L：" + "子线程的返回值：" + ft.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//}
//

public class threadDemo3 implements Callable<Integer> {
    public static void main(String[] args) {
        threadDemo3 ctt = new threadDemo3();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Integer call() {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}