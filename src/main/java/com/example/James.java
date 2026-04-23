package com.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents James, an employee at Homer.inc with a passion for snow globes
 * and a legally questionable approach to colleting them.
 *
 * <p>James solves the classic knapsack problem, greedily selecting snow globes
 * by their value-to-weight ratio until his bag is full. He is very good at his job.</p>
 */
public class James {
    private List<SnowGlobe> knapsack = new ArrayList<>();
    private double capacity;

    /**
     * Constructs a new James with a given carrying capacity.
     *
     * @param capacity the maximum weight James can carry in his knapsack
     */
    public James(double capacity) {
        this.capacity = capacity;
    }

    /**
     * Determines whether James can fit one more snow globe in his knapsack
     * without exceeding his weight capacity.
     *
     * @param snowGlobe the snow globe James is eyeing
     * @return {@code true} if the globe fits, {@code false} if James needs to
     *         leave it on the shelf and walk away
     */
    private boolean canTake(SnowGlobe snowGlobe) {
        double currentWeight = knapsack.stream()
            .mapToDouble(SnowGlobe::getWeight)
            .sum();
        return currentWeight + snowGlobe.getWeight() <= capacity;
    }

    /**
     * Greedily selects snow globes from the given list, prioritizing those with
     * the highest value-to-weight ratio, until no more will fit.
     *
     * @param snowGlobes the list of snow globes available for James to take
     */
    public void takeSnowGlobes(List<SnowGlobe> snowGlobes) {
        snowGlobes.stream()
            .sorted((a, b) -> Double.compare(
                b.getValue() / b.getWeight(),
                a.getValue() / a.getWeight()
            ))
            .filter(this::canTake)
            .forEach(knapsack::add);
    }

    /**
     * Prints a summary of everything James has stuffed into his knapsack,
     * including each globe's details and the total value and weight.
     */
    public void printKnapsack() {
        System.out.println("James's Knapsack:");
        knapsack.forEach(sg -> System.out.println("  " + sg));
        double totalValue = knapsack.stream().mapToDouble(SnowGlobe::getValue).sum();
        double totalWeight = knapsack.stream().mapToDouble(SnowGlobe::getWeight).sum();
        System.out.printf("  Total Value: %.2f | Total Weight: %.2f / %.2f%n", totalValue, totalWeight, capacity);
    }
    
    /**
     * Returns the contents of James's knapsack.
     *
     * <p><b>This method is private and must stay that way.</b> Homer.inc legal has been
     * very clear on this point. Do not ask why. Do not look into it further.</p>
     *
     * <p>And yet, the testing harness needs it. Your job is to figure out how to
     * call this method from {@code JamesTest} without touching its visibility modifier.
     * The {@link ExposeForTesting} annotation and {@link TestHarness} are your friends.</p>
     *
     * @return the list of snow globes currently in James's knapsack
     */
    private List<SnowGlobe> getKnapsack() { return knapsack; }
}
