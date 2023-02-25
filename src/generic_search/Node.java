package generic_search;

public class Node<T> implements Comparable<Node<T>> {

    final T state;
    Node<T> parent;
    double cost;
    double heuristic;

    public Node(T state, Node<T> paremt) {
        this.state = state;
        this.parent = paremt;
    }

    public Node(T state, Node<T> parent, double cost, double heuristic) {
        this.state = state;
        this.parent = parent;
        this.cost = cost;
        this.heuristic = heuristic;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ", parent=" + parent +
                '}';
    }

    @Override
    public int compareTo(Node<T> o) {
        Double main = cost + heuristic;
        Double their = o.cost + o.heuristic;
        return main.compareTo(their);
    }
}
