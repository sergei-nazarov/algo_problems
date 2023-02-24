package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Graph<V, E extends Edge> {
    private List<V> vertices = new ArrayList<>();
    protected List<List<E>> edges = new ArrayList<>();

    public Graph(List<V> vertices) {
        this.vertices = vertices;
        for (V vertex : vertices) {
            edges.add(new ArrayList<>());
        }
    }

    public Graph() {
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public int addVertex(V vertex) {
        vertices.add(vertex);
        edges.add(new ArrayList<>());
        return getVertexCount() - 1;
    }

    public V vertexAt(int index) {
        return vertices.get(index);
    }

    public int indexOf(V vertex) {
        return vertices.indexOf(vertex);
    }

    public List<V> neighborsOf(int index) {
        return edges.get(index).stream().map(edge -> vertexAt(edge.v)).toList();
    }

    public List<V> neighborsOf(V vertex) {
        return neighborsOf(indexOf(vertex));
    }

    public List<E> edgesOf(int index) {
        return edges.get(index);
    }

    public List<E> edgesOf(V vertex) {
        return edgesOf(indexOf(vertex));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getVertexCount(); i++) {
            sb.append(vertexAt(i));
            sb.append(" -> ");
            sb.append(Arrays.toString(neighborsOf(i).toArray()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
