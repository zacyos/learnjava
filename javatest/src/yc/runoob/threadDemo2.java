package yc.runoob;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class threadDemo2 {
    public static void main(String[] args) {
        Callable<Integer> callable = () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        };

        System.out.println(callable);

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        try {
            int sum = futureTask.get();
            System.out.println("1~100的和为：" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}