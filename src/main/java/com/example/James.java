package com.example;
import java.util.ArrayList;
import java.util.List;


public class James {
    private List<SnowGlobe> knapsack = new ArrayList<>();
    private double capacity;

    public James(double capacity) {
        this.capacity = capacity;
    }

    private boolean canTake(SnowGlobe snowGlobe) {
        double currentWeight = knapsack.stream()
            .mapToDouble(SnowGlobe::getWeight)
            .sum();
        return currentWeight + snowGlobe.getWeight() <= capacity;
    }

    public void takeSnowGlobes(List<SnowGlobe> snowGlobes) {
        snowGlobes.stream()
            .sorted((a, b) -> Double.compare(
                b.getValue() / b.getWeight(),
                a.getValue() / a.getWeight()
            ))
            .filter(this::canTake)
            .forEach(knapsack::add);
    }

    public void printKnapsack() {
        System.out.println("James's Knapsack:");
        knapsack.forEach(sg -> System.out.println("  " + sg));
        double totalValue = knapsack.stream().mapToDouble(SnowGlobe::getValue).sum();
        double totalWeight = knapsack.stream().mapToDouble(SnowGlobe::getWeight).sum();
        System.out.printf("  Total Value: %.2f | Total Weight: %.2f / %.2f%n", totalValue, totalWeight, capacity);
    }

    public List<SnowGlobe> getKnapsack() { return knapsack; }
}
