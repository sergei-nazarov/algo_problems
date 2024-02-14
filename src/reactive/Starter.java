package reactive;

public class Starter {
    public static void main(String[] args) {
        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c3 = new SimpleCell("C3");
        ArithmeticCell c4 = new ArithmeticCell("C4");
        c1.subscribe(c4::setLeft);
        c2.subscribe(c4::setRight);
        c2.subscribe(x-> System.out.println(x + " Простой сабскрайбер"));

        c1.subscribe(c3);
        c1.onNext(1);
        c2.onNext(3);


    }
}
