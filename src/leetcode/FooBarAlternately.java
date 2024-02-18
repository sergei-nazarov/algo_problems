package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBarAlternately {
    private int n;
    boolean foo = true;

    public FooBarAlternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (this){
                while (!foo){
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                foo=!foo;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (this){
                while (foo){
                    wait();
                }
                printBar.run();
                foo=!foo;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBarAlternately fooBarAlternately = new FooBarAlternately(3);

        new Thread(() -> {
            try {
                fooBarAlternately.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fooBarAlternately.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }

}
