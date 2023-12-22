package 多线程.新的可重入锁ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter{
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n){
        lock.lock();
        try {
            count +=n;
            System.out.println(count);
        } finally {
            lock.unlock();
        }
    }
}
