package 多线程.线程池;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = corePoolSize * 2;
        long keepAliveTime = 60L;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(100);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler
        );
        // 任务过多有可能触发拒绝策略和内存溢出，所以不要一股脑的交给线程池去处理
        for (int i = 0; i < 200; i++) {
            // 使用线程池执行任务
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("Task executed"+ finalI);
            });
        }
        System.out.println("+++++++++");

        // 关闭线程池
        threadPoolExecutor.shutdown();
    }

}
