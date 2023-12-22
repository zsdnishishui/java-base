package 多线程.唤醒线程;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    Queue<String> queue = new LinkedList<>();
    public synchronized void addTask(String s){
        this.queue.add(s);
        this.notify();
    }
    public synchronized String getTask() throws InterruptedException{
        while (queue.isEmpty()){
            this.wait();
        }
        return queue.remove();
    }
}
