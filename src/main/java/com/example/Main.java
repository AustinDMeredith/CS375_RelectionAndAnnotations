package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        James james = new James(10);

        List<SnowGlobe> snowGlobes = List.of(
            new SnowGlobe("Eiffel Tower",   10, 2),
            new SnowGlobe("Big Ben",          8, 3),
            new SnowGlobe("Statue of Liberty",15, 7),
            new SnowGlobe("Colosseum",         6, 4),
            new SnowGlobe("Sydney Opera",      9, 5)
        );

        james.takeSnowGlobes(snowGlobes);
        james.printKnapsack();
    }
}
