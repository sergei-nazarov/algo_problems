package generic_search;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class GenericSearch {

    public static <T> Node<T> aStar(T initial, Predicate<T> goalTest, Function<T, List<T>> successors, ToDoubleFunction<T> heuristic) {
        Map<T, Double> explored = new HashMap<>();
        Queue<Node<T>> frontier = new PriorityQueue<>();
        explored.put(initial, 0.0);
        frontier.offer(new Node<T>(initial, null, 0, heuristic.applyAsDouble(initial)));
        int counter = 0;
        while (!frontier.isEmpty()) {
            counter++;
            Node<T> currentNode = frontier.poll();
            T currentState = currentNode.state;
            if (goalTest.test(currentState)) {
                System.out.println("Количество итераций: " + counter);
                return currentNode;
            }
            for (T child : successors.apply(currentState)) {
                double newCost = currentNode.cost + 1;
                if (!explored.containsKey(child) || explored.get(child) > newCost) {
                    explored.put(child, newCost);
                    frontier.offer(new Node<>(child, currentNode, newCost, heuristic.applyAsDouble(child)));
                }

            }

        }
        System.out.println("Количество итераций: " + counter);
        return null;
    }

    public static <T> Node<T> dfs(T initial, Predicate<T> goalTest, Function<T, List<T>> successors) {
        Set<T> explored = new HashSet<>();
        Stack<Node<T>> frontier = new Stack<>();
        explored.add(initial);
        frontier.push(new Node<T>(initial, null));
        int counter = 0;
        while (!frontier.isEmpty()) {
            counter++;
            Node<T> currentNode = frontier.pop();
            T currentState = currentNode.state;
            if (goalTest.test(currentState)) {
                System.out.println("Количество итераций: " + counter);
                return currentNode;
            }//////
            for (T child : successors.apply(currentState)) {
                if (explored.contains(child)) {
                    continue;
                }
                explored.add(child);
                frontier.push(new Node<>(child, currentNode));
            }
        }
        System.out.println("Количество итераций: " + counter);
        return null;
    }

    public static <T> Node<T> bfs(T initial, Predicate<T> goalTest, Function<T, List<T>> successors) {
        Set<T> explored = new HashSet<>();
        Queue<Node<T>> frontier = new LinkedList<>();
        explored.add(initial);
        frontier.offer(new Node<T>(initial, null));
        int counter = 0;
        while (!frontier.isEmpty()) {
            counter++;
            Node<T> currentNode = frontier.poll();
            T currentState = currentNode.state;
            if (goalTest.test(currentState)) {
                System.out.println("Количество итераций: " + counter);
                return currentNode;
            }
            for (T child : successors.apply(currentState)) {
                if (explored.contains(child)) {
                    continue;
                }
                explored.add(child);
                frontier.offer(new Node<>(child, currentNode));
            }

        }
        System.out.println("Количество итераций: " + counter);
        return null;
    }

    public static <T> List<T> nodeToPath(Node<T> node) {
        List<T> path = new ArrayList<>();
        path.add(node.state);
        while (node.parent != null) {
            node = node.parent;
            path.add(0, node.state);
        }
        return path;
    }
}
