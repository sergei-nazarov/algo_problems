package leetcode;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder_1114 {

    public void first() { System.out.print("first"); }
    public void second() { System.out.print("second"); }
    public void third() { System.out.print("third"); }

    CountDownLatch second = new CountDownLatch(1);
    CountDownLatch third = new CountDownLatch(1);


    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        second.await();
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        third.await();
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder_1114 printInOrder = new PrintInOrder_1114();
        printInOrder.first(printInOrder::first);
        printInOrder.second(printInOrder::second);
        printInOrder.third(printInOrder::third);
    }


}
