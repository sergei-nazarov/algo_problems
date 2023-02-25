package genetic_algorithm;

import java.util.List;

public abstract class Chromosome<T extends Chromosome<T>> implements Comparable<T> {
    public abstract double fitness();

    public abstract List<T> crossover();

    public abstract T copy();

    @Override
    public int compareTo(T o) {
        Double main = fitness();
        Double their = o.fitness();
        return main.compareTo(their);
    }
}
