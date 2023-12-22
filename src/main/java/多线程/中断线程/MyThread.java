package 多线程.中断线程;

public class MyThread extends Thread {
    public volatile boolean running = true;
    @Override
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}