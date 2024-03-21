package modern_java;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class LazyList<T> implements MyList<T> {
    static int d = 0;

    private final T head;
    private final Supplier<LazyList<T>> tail;

    public LazyList(T head, Supplier<LazyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public LazyList<T> tail() {
        return tail.get();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public LazyList<T> filter(Predicate<T> p) {
        return isEmpty() ? this : p.test(head()) ? new LazyList<>(head(), () -> tail().filter(p)) : tail().filter(p);
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    public static LazyList<Integer> primes(LazyList<Integer> numbers) {
        if (numbers.isEmpty()) {
            return null;
        }
        int head = numbers.head();
        System.out.println("Head: " + head);
        LazyList<Integer> tail = numbers.tail().filter(n -> n % head != 0);
        System.out.print("Tail: ");
        LazyList<Integer> nextNumbers = tail;
        for (int i = 0; i < 20 && !nextNumbers.isEmpty(); i++) {
            System.out.print(nextNumbers.head() + " ");
            nextNumbers = nextNumbers.tail();
        }
        return new LazyList<>(head, () -> primes(tail));
    }

    public static <T> void printAll(MyList<T> list) {
        if (list.isEmpty()) {
            return;
        }
        System.out.println(list.head());
        printAll(list.tail());
    }

    public static void main(String[] args) {
        LazyList<Integer> numbers = from(2);
//        int two = numbers.head();
//        int three = numbers.tail().head();
//        int four = numbers.tail().tail().head();
//        System.out.println(two + " " + three + " " + four);

//        two = primes(numbers).head();
//        three = primes(numbers).tail().head();
//        four = primes(numbers).tail().tail().head();
//        int five = primes(numbers).tail().tail().tail().head();
//        int six = primes(numbers).tail().tail().tail().tail().head();
        int seven = primes(numbers).tail().tail().tail().tail().tail().head();
        System.out.println(seven);

//        System.out.println(two + " " + three + " " + four + " " + five + " " + six);


    }
}
