package modern_java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequenceThreadFrame {

    public List<String> sequence() throws InterruptedException {
        var out = new CopyOnWriteArrayList<String>();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        var first = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                lock.lock();
                out.add("first");
                condition.signalAll();
                try {
                    if(i!=2){
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        });

        var second = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                lock.lock();
                out.add("second");
                condition.signalAll();
                try {
                    if(i!=2){
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
        return out;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new SequenceThreadFrame().sequence());
    }
}
