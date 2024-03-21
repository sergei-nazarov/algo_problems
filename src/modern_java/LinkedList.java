package modern_java;

import java.util.function.Predicate;

interface MyList<T> {
    T head();
    MyList<T> tail();
    default boolean isEmpty(){
        return true;
    }
}
public class LinkedList<T> implements MyList<T> {
    private final T head;
    private final MyList<T> tail;

    public LinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
class Empty<T> implements MyList<T>{

    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }
}
