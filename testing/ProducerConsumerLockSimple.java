package testing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLockSimple {

    static Queue<Integer> queue = new LinkedList<>();
    static int capacity = 5;
    static Lock lock = new ReentrantLock();
    static Condition notFull = lock.newCondition();
    static Condition notEmpty = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        // Producer
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {}
        }).start();

        // Consumer
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    consume();
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {}
        }).start();

        Thread.sleep(5000);
    }

    static void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await(); // Wait if full
            }
            queue.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signal(); // Wake consumer
        } finally {
            lock.unlock();
        }
    }

    static void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await(); // Wait if empty
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            notFull.signal(); // Wake producer
        } finally {
            lock.unlock();
        }
    }
}