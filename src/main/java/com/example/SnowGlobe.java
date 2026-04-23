package com.example;

/**
 * Represents a snow globe, the world's most impractical souvenir and the
 * cornerstone of James's retirement plan.
 *
 * <p>Each snow globe has a name, a monetary value, and a weight. James will
 * evaluate these properties to determine which globes are worth squeezing
 * into his knapsack and which ones get left behind at the gift shop.</p>
 */
public class SnowGlobe {
    private String name;
    private double value;
    private double weight;

    /**
     * Constructs a new SnowGlobe with the given properties.
     *
     * @param name   the name of the snow globe (typically a landmark James
     *               was supposed to be working near)
     * @param value  the monetary value of the snow globe, in dollars
     * @param weight the weight of the snow globe, in kilograms. James's
     *               back is not what it used to be
     */
    public SnowGlobe(String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    /**
     * Returns the name of this snow globe.
     *
     * @return the snow globe's name
     */
    public String getName() { return name; }

    /**
     * Returns the monetary value of this snow globe.
     *
     * @return the value in dollars
     */
    public double getValue() { return value; }

    /**
     * Returns the weight of this snow globe.
     *
     * @return the weight in kilograms
     */
    public double getWeight() { return weight; }

    /**
     * Returns a string representation of this snow globe, including its
     * value-to-weight ratio, a VERY important number to James.
     *
     * @return a formatted string summarizing the snow globe's properties
     */
    @Override
    public String toString() {
        return String.format("SnowGlobe{name='%s', value=%.2f, weight=%.2f, ratio=%.2f}",
            name, value, weight, value / weight);
    }
}
