package 多线程.唤醒线程;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Thread t = new Thread(()->{
                // 执行task
                while (true){
                    try {
                        String s = q.getTask();
                        System.out.println("execute task:" + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }
        for (int i = 0; i < 500; i++) {
            Thread add = new Thread(() -> {
                // 放入task
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            add.start();
//            add.join();
        }

        Thread.sleep(1000);
        for (Thread t : ts) {
            t.interrupt();
        }
    }
}
