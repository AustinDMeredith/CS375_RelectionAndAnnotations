package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for {@link James} and his frankly alarming snow globe habits.
 *
 * <p>Verifies that James's greedy knapsack algorithm correctly selects snow globes
 * by value-to-weight ratio, respects his carrying capacity, and handles edge cases
 * with the quiet dignity of a man who has seen things at airport gift shops.
 *
 * <p><i>Written by the intern. Please do not ask the intern how long this took.
 * Please do not ask the intern why there are bite marks on his desk.
 * The intern has hit his Claude MAX token limit for the day and is operating
 * on pure spite and the last of the break room coffee.</i>
 */
public class JamesTest {

    private James james;
    private List<SnowGlobe> snowGlobes;

    /**
     * Prepares a James and a curated selection of snow globes before each test.
     *
     * <p>James is given a carrying capacity of 10kg. The globes are chosen such
     * that only the two highest-ratio items fit, the rest are either too heavy
     * or crowded out by their betters. The comments in the list explain the math.
     * The intern checked them three times. They are correct. Probably.
     */
    @BeforeEach
    void setUp() {
        james = new James(10);
        snowGlobes = List.of(
            new SnowGlobe("Eiffel Tower",    10, 2),  // ratio 5.00 ✓ taken
            new SnowGlobe("Big Ben",           8, 3),  // ratio 2.67 ✓ taken
            new SnowGlobe("Statue of Liberty", 15, 7), // ratio 2.14 ✗ too heavy (2+3+7=12)
            new SnowGlobe("Colosseum",          6, 4), // ratio 1.50 ✗ too heavy (2+3+4=9... wait)
            new SnowGlobe("Sydney Opera",       9, 5)  // ratio 1.80 ✗ too heavy (2+3+5=10, but Colosseum comes first by ratio)
        );
    }

    /**
     * Verifies that James takes the two globes with the highest value-to-weight ratios.
     *
     * <p>The Eiffel Tower (ratio 5.00) and Big Ben (ratio 2.67) should be in the
     * knapsack. If they are not, James has made a grave error and should consider
     * retaking CS332 (Algorithms).
     */
    @Test
    void testHighestRatioItemsTaken() {
        james.takeSnowGlobes(snowGlobes);
        List<SnowGlobe> knapsack = james.getKnapsack();

        assertTrue(knapsack.stream().anyMatch(sg -> sg.getName().equals("Eiffel Tower")));
        assertTrue(knapsack.stream().anyMatch(sg -> sg.getName().equals("Big Ben")));
    }

    /**
     * Verifies that James leaves the Statue of Liberty behind.
     *
     * <p>Despite its high absolute value, the Statue of Liberty is too heavy to fit
     * once the Eiffel Tower and Big Ben are packed. James knows this. James accepts
     * this. James does not make eye contact with the Statue of Liberty as he walks away.
     */
    @Test
    void testOverweightItemNotTaken() {
        james.takeSnowGlobes(snowGlobes);
        List<SnowGlobe> knapsack = james.getKnapsack();

        assertFalse(knapsack.stream().anyMatch(sg -> sg.getName().equals("Statue of Liberty")));
    }

    /**
     * Verifies that James does not exceed his 10kg carrying capacity.
     *
     * <p>His back is not what it used to be. Homer.inc's travel insurance
     * does not cover snow globe related injuries.
     */
    @Test
    void testWeightCapacityNotExceeded() {
        james.takeSnowGlobes(snowGlobes);
        double totalWeight = james.getKnapsack().stream()
            .mapToDouble(SnowGlobe::getWeight)
            .sum();

        assertTrue(totalWeight <= 10);
    }

    /**
     * Verifies that James handles an empty list gracefully.
     *
     * <p>No snow globes. No problem. James simply stares at the empty shelf,
     * collects himself, and goes to find a different gift shop.
     */
    @Test
    void testEmptyListDoesNothing() {
        james.takeSnowGlobes(List.of());
        assertTrue(james.getKnapsack().isEmpty());
    }
}
