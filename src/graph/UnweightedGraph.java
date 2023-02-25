package graph;

import generic_search.GenericSearch;
import generic_search.Node;

import java.util.List;

public class UnweightedGraph<V> extends Graph<V, Edge> {

    public UnweightedGraph(List<V> vertices) {
        super(vertices);
    }

    public void addEdge(Edge edge) {
        edges.get(edge.u).add(edge);
        edges.get(edge.v).add(edge.reversed());
    }

    public void addEdge(int u, int v) {
        addEdge(new Edge(u, v));
    }

    public void addEdge(V first, V second) {
        addEdge(new Edge(indexOf(first), indexOf(second)));
    }


    public static void main(String[] args) {
        UnweightedGraph<String> cityGraph = new UnweightedGraph<>(
                List.of("Seattle", "San Francisco", "Los Angeles", "Riverside",
                        "Phoenix", "Chicago", "Boston", "New York", "Atlanta", "Miami",
                        "Dallas", "Houston", "Detroit", "Philadelphia", "Washington"));

        cityGraph.addEdge("Seattle", "Chicago");
        cityGraph.addEdge("Seattle", "San Francisco");
        cityGraph.addEdge("San Francisco", "Riverside");
        cityGraph.addEdge("San Francisco", "Los Angeles");
        cityGraph.addEdge("Los Angeles", "Riverside");
        cityGraph.addEdge("Los Angeles", "Phoenix");
        cityGraph.addEdge("Riverside", "Phoenix");
        cityGraph.addEdge("Riverside", "Chicago");
        cityGraph.addEdge("Phoenix", "Dallas");
        cityGraph.addEdge("Phoenix", "Houston");
        cityGraph.addEdge("Dallas", "Chicago");
        cityGraph.addEdge("Dallas", "Atlanta");
        cityGraph.addEdge("Dallas", "Houston");
        cityGraph.addEdge("Houston", "Atlanta");
        cityGraph.addEdge("Houston", "Miami");
        cityGraph.addEdge("Atlanta", "Chicago");
        cityGraph.addEdge("Atlanta", "Washington");
        cityGraph.addEdge("Atlanta", "Miami");
        cityGraph.addEdge("Miami", "Washington");
        cityGraph.addEdge("Chicago", "Detroit");
        cityGraph.addEdge("Detroit", "Boston");
        cityGraph.addEdge("Detroit", "Washington");
        cityGraph.addEdge("Detroit", "New York");
        cityGraph.addEdge("Boston", "New York");
        cityGraph.addEdge("New York", "Philadelphia");
        cityGraph.addEdge("Philadelphia", "Washington");

        System.out.println(cityGraph);

        Node<String> bfsResult = GenericSearch.bfs("Boston", v -> v.equals("Miami"), cityGraph::neighborsOf);
        if (bfsResult == null) {
            System.out.println("No solution");
        } else {
            List<String> path = GenericSearch.nodeToPath(bfsResult);
            System.out.println("Path from Boston to Miami");
            System.out.println(path);

        }

    }
}
