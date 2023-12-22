package 多线程.线程的状态;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是第一个线程");
        });
        t.start();
        t.join(); // 线程t执行完了，才能执行下面的语句，也可以指定执行时间，超过这个时间，就可以不等了
        System.out.println("这是main线程");
    }
}
