package reactive;

import java.util.ArrayList;
import java.util.List;

public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {
    private int value;
    private String name;
    private final List<Subscriber<? super Integer>> subscribers = new ArrayList<>();

    public SimpleCell(String name) {
        this.name = name;
    }

    private void notifyAllSubscribers() {
        subscribers.forEach(x -> x.onNext(value));
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void onNext(Integer value) {
        this.value = value;
        System.out.println(this.name + " : " + value);
        notifyAllSubscribers();
    }
}
