package 多线程.新的可重入锁ReentrantLock;

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread addThread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                counter.add(1);
            }
        });
        addThread.start();

        Thread decThread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                counter.add(-1);
            }
        });
        decThread.start();

    }


}
