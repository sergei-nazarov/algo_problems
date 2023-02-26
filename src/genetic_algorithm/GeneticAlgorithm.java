package genetic_algorithm;

import java.util.*;

public class GeneticAlgorithm<C extends Chromosome<C>> {

    public enum SelectionType {
        ROULETTE, TOURNAMENT
    }

    private List<C> population;
    private double mutationChance;
    private double crossoverChance;
    private SelectionType selectionType;
    private Random random;

    public GeneticAlgorithm(List<C> initialPopulation, double mutationChance, double crossoverChance, SelectionType selectionType) {
        this.population = initialPopulation;
        this.mutationChance = mutationChance;
        this.crossoverChance = crossoverChance;
        this.selectionType = selectionType;
        random = new Random();
    }

    private List<C> pickRoulette(double[] wheel, int numPicks) {
        List<C> picks = new ArrayList<>();
        for (int i = 0; i < numPicks; i++) {
            double pick = random.nextDouble();
            for (int j = 0; j < wheel.length; j++) {
                pick -= wheel[j];
                if (pick <= 0) {
                    picks.add(population.get(j));
                    break;
                }
            }
        }
        return picks;
    }

    private List<C> pickTournament(int numParticipants, int numPicks) {
        Collections.shuffle(population, random);
        List<C> tournament = population.subList(0, numParticipants);
        tournament.sort(Collections.reverseOrder());
        return tournament.subList(0, numPicks);
    }

    private void reproduceAndReplace() {
        List<C> nextPopulation = new ArrayList<>();
        while (nextPopulation.size() < population.size()) {
            List<C> parents = new ArrayList<>();
            if (selectionType == SelectionType.ROULETTE) {
                double totalFitness = population.stream().mapToDouble(Chromosome::fitness).sum();
                double[] wheel = population.stream().mapToDouble(x -> x.fitness() / totalFitness).toArray();
                parents = pickRoulette(wheel, 2);
            } else {
                parents = pickTournament(population.size() / 2, 2);
            }

            if (random.nextDouble() < crossoverChance) {
                C parent1 = parents.get(0);
                C parent2 = parents.get(1);
                nextPopulation.addAll(parent1.crossover(parent2));
            } else {
                nextPopulation.addAll(parents);
            }

        }
        if (nextPopulation.size() > population.size()) {
            nextPopulation.remove(0);
        }
        population = nextPopulation;
    }

    private void mutate() {
        for (C individual : population) {
            if (random.nextDouble() < mutationChance) {
                individual.mutate();
            }
        }
    }

    public C run(int maxGeneration, double threshold) {
        C best = Collections.max(population).copy();
        for (int generation = 0; generation < maxGeneration; generation++) {
            if (best.fitness() >= threshold) {
                return best;
            }
            System.out.println("Generation " + generation +
                    " Best " + best.fitness() +
                    " Avg " + population.stream().mapToDouble(Chromosome::fitness).average().orElse(0.0));
            reproduceAndReplace();
            mutate();
            C highest = Collections.max(population);
            if (highest.fitness() > best.fitness()) {
                best = highest.copy();
            }
        }
        return best;
    }
}

