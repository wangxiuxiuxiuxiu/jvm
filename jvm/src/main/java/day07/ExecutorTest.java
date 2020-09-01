package day07;

import java.util.concurrent.*;

//线程池
public class ExecutorTest implements Runnable{

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
        3,
        60,
        TimeUnit.SECONDS, new LinkedBlockingQueue<>(5),Executors.defaultThreadFactory()
        );

        for (int i=0;i<9;i++){
            threadPoolExecutor.execute(new ExecutorTest());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println("我是线程："+Thread.currentThread().getName());
    }
}
