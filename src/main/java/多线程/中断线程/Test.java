package 多线程.中断线程;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // 第一种中断方式
//        Thread t = new Thread(()->{
//            int n = 0;
//            while (! Thread.currentThread().isInterrupted()){
//                n ++;
//                System.out.println(n+" hello!");
//            }
//        });
//        t.start();
//        Thread.sleep(1);// 暂停1毫秒
//        t.interrupt();// 中断t线程
//        t.join(); // 等待t线程结束
//        System.out.println("end");
        // 第二种中断方式
//        Thread t = new Thread(()->{
//
//            Thread hello = new Thread(()->{
//                int n = 0;
//                while (! Thread.currentThread().isInterrupted()){
//                    n ++;
//                    System.out.println(n+" hello!");
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        System.out.println("break");
//                        break;
//                    }
//                }
//            });
//            hello.start(); // 启动hello线程
//            try {
//                hello.join();
//            } catch (InterruptedException e) {
//                System.out.println("interrupted!");
//            }
//            hello.interrupt();
//        });
//        t.start();
//        Thread.sleep(1000);// 暂停1秒
//        t.interrupt();// 中断t线程
//        t.join(); // 等待t线程结束
//        System.out.println("end");

        // 第三种方式设置标志位
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1);// 暂停1毫秒
        t.running = false;

    }
}
