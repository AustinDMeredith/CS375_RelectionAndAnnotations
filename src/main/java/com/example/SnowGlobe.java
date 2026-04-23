package com.example;

public class SnowGlobe {
    private String name;
    private double value;
    private double weight;

    public SnowGlobe(String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getValue() { return value; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return String.format("SnowGlobe{name='%s', value=%.2f, weight=%.2f, ratio=%.2f}",
            name, value, weight, value / weight);
    }
}
