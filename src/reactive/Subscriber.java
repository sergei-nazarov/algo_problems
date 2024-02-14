package reactive;

public interface Subscriber<T> {
    void onNext(T t);
}
