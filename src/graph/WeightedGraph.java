package graph;

import java.util.*;
import java.util.function.IntConsumer;

public class WeightedGraph<V> extends Graph<V, WeightedEdge> {
    public WeightedGraph(List<V> vertices) {
        super(vertices);
    }

    public void addEdge(WeightedEdge edge) {
        edges.get(edge.u).add(edge);
        edges.get(edge.v).add(edge.reversed());
    }

    public void addEdge(int u, int v, float weight) {
        addEdge(new WeightedEdge(u, v, weight));
    }

    public void addEdge(V first, V second, float weight) {
        addEdge(new WeightedEdge(indexOf(first), indexOf(second), weight));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getVertexCount(); i++) {
            sb.append(vertexAt(i));
            sb.append(" -> ");
            sb.append(Arrays.toString(edgesOf(i).stream().map(we -> "(" + vertexAt(we.v) + ", " + we.weight + ")").toArray()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public List<WeightedEdge> mst(int start) {
        LinkedList<WeightedEdge> result = new LinkedList<>();

        if (start < 0 || start > getVertexCount() - 1) {
            return result;
        }

        Queue<WeightedEdge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[getVertexCount()];

        IntConsumer visit = index -> {
            visited[index] = true;
            for (WeightedEdge edge : edgesOf(index)) {
                if (!visited[edge.v]) {
                    pq.offer(edge);
                }
            }
        };
        visit.accept(start);
        while (!pq.isEmpty()) {
            WeightedEdge edge = pq.poll();
            if (visited[edge.v]) {
                continue;
            }
            result.add(edge);
            visit.accept(edge.v);
        }

        return result;
    }

    public void printWeightedPath(List<WeightedEdge> wp) {
        for (WeightedEdge edge : wp) {
            System.out.println(vertexAt(edge.u) + " " + edge.weight + "> " + vertexAt(edge.v));
        }
        System.out.println("Total Weight: " + totalWeight(wp));
    }

    public static double totalWeight(List<WeightedEdge> path) {
        return path.stream().mapToDouble(x -> x.weight).sum();
    }

    public static void main(String[] args) {
        WeightedGraph<String> cityGraph = new WeightedGraph<>(List.of("Seattle", "San Francisco", "Los Angeles", "Riverside", "Phoenix", "Chicago", "Boston", "New York", "Atlanta", "Miami", "Dallas", "Houston", "Detroit", "Philadelphia", "Washington"));

        cityGraph.addEdge("Seattle", "Chicago", 1737);
        cityGraph.addEdge("Seattle", "San Francisco", 678);
        cityGraph.addEdge("San Francisco", "Riverside", 386);
        cityGraph.addEdge("San Francisco", "Los Angeles", 348);
        cityGraph.addEdge("Los Angeles", "Riverside", 50);
        cityGraph.addEdge("Los Angeles", "Phoenix", 357);
        cityGraph.addEdge("Riverside", "Phoenix", 307);
        cityGraph.addEdge("Riverside", "Chicago", 1704);
        cityGraph.addEdge("Phoenix", "Dallas", 887);
        cityGraph.addEdge("Phoenix", "Houston", 1015);
        cityGraph.addEdge("Dallas", "Chicago", 805);
        cityGraph.addEdge("Dallas", "Atlanta", 721);
        cityGraph.addEdge("Dallas", "Houston", 225);
        cityGraph.addEdge("Houston", "Atlanta", 702);
        cityGraph.addEdge("Houston", "Miami", 968);
        cityGraph.addEdge("Atlanta", "Chicago", 588);
        cityGraph.addEdge("Atlanta", "Washington", 543);
        cityGraph.addEdge("Atlanta", "Miami", 604);
        cityGraph.addEdge("Miami", "Washington", 923);
        cityGraph.addEdge("Chicago", "Detroit", 238);
        cityGraph.addEdge("Detroit", "Boston", 613);
        cityGraph.addEdge("Detroit", "Washington", 396);
        cityGraph.addEdge("Detroit", "New York", 482);
        cityGraph.addEdge("Boston", "New York", 190);
        cityGraph.addEdge("New York", "Philadelphia", 81);
        cityGraph.addEdge("Philadelphia", "Washington", 123);
        System.out.println(cityGraph);
        System.out.println();
        cityGraph.printWeightedPath(cityGraph.mst(0));
        System.out.println();
        DijkstraResult losAngeles = cityGraph.dijkstra("Los Angeles");
        Map<String, Double> losAngelesDistance = cityGraph.distanceArrayToDistanceMap(losAngeles.distances);
        System.out.println("Distances from Los Angeles :");
        losAngelesDistance.forEach((x, y) -> System.out.println(x + " : " + y));
        System.out.println();
        List<WeightedEdge> path = pathMapToPath(cityGraph.indexOf("Los Angeles"), cityGraph.indexOf("Boston"), losAngeles.pathMap);
        System.out.println("Shortest path from Los Angeles to Boston:");
        cityGraph.printWeightedPath(path);
    }

    public static class DijkstraNode implements Comparable<DijkstraNode> {
        public final int vertex;
        public final double distance;

        public DijkstraNode(int vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }


        @Override
        public int compareTo(DijkstraNode o) {
            Double mine = distance;
            Double their = o.distance;
            return mine.compareTo(distance);
        }
    }

    public static final class DijkstraResult {
        public final double[] distances;
        public final Map<Integer, WeightedEdge> pathMap;

        public DijkstraResult(double[] distances, Map<Integer, WeightedEdge> pathMap) {
            this.distances = distances;
            this.pathMap = pathMap;
        }
    }

    public DijkstraResult dijkstra(V root) {
        int first = indexOf(root);
        Map<Integer, WeightedEdge> pathMap = new HashMap<>();
        double[] distances = new double[getVertexCount()];
        boolean[] visited = new boolean[getVertexCount()];
        distances[first] = 0;
        visited[first] = true;
        Queue<DijkstraNode> pq = new PriorityQueue<>();
        pq.offer(new DijkstraNode(first, 0));
        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            double distU = distances[u];
            for (WeightedEdge we : edgesOf(u)) {
                double distV = distances[we.v];
                double pathWeight = distU + we.weight;
                if (!visited[we.v] || distV > pathWeight) {
                    visited[we.v] = true;
                    distances[we.v] = pathWeight;
                    pathMap.put(we.v, we);
                    pq.offer(new DijkstraNode(we.v, pathWeight));
                }
            }
        }
        return new DijkstraResult(distances, pathMap);
    }

    public Map<V, Double> distanceArrayToDistanceMap(double[] distances) {
        Map<V, Double> distanceMap = new HashMap<>();
        for (int i = 0; i < distances.length; i++) {
            distanceMap.put(vertexAt(i), distances[i]);
        }
        return distanceMap;
    }

    public static List<WeightedEdge> pathMapToPath(int start, int end, Map<Integer, WeightedEdge> pathMap) {
        if (pathMap.size() == 0) {
            return List.of();
        }
        LinkedList<WeightedEdge> path = new LinkedList<>();
        WeightedEdge edge = pathMap.get(end);
        path.add(edge);
        while (edge.u != start) {
            edge = pathMap.get(edge.u);
            path.add(edge);
        }
        Collections.reverse(path);
        return path;

    }
}
