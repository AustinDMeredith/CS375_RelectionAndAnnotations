package com.example;

import java.util.List;

/**
 * The beginning of the end for James.
 *
 * <p>It was supposed to be a routine academic conference. James had one
 * job, present his paper on the HCI of stove tops (amoung other household appliences) 
 * at Homer.inc's annual symposium and come straight back to the university. 
 * 
 * <p><i>But then he saw them. </i></p>
 *
 * <p>Gleaming under the gift shop fluorescents. A pile of snow globes, 
 * each one a tiny world unto itself.</p>
 *
 * <p>James is a rational man. A man of science. He would approach this
 * the same way he approached every problem: methodically, optimally, and with
 * absolutely no regard for the gift shop's return policy. He had derived a system.
 * He had packed a knapsack. He had a tenure that protected him from most consequences.</p>
 */
public class Main {

    /**
     * James makes his move.
     *
     * @param args ignored, James does not take requests
     */
    public static void main(String[] args) {
        // James sizes up the situation. Ten kilograms of carrying capacity.
        // He has done this before.
        James james = new James(10);

        // There they were. Five snow globes. Innocent. Unguarded.
        // James's eyes narrowed as he calculated the ratios in his head.
        List<SnowGlobe> snowGlobes = List.of(
            new SnowGlobe("Eiffel Tower",   10, 2),
            new SnowGlobe("Big Ben",          8, 3),
            new SnowGlobe("Statue of Liberty",15, 7),
            new SnowGlobe("Colosseum",         6, 4),
            new SnowGlobe("Sydney Opera",      9, 5)
        );

        // He was methodical. Greedy, yes but efficiently greedy.
        // The lesser globes would have to stay. He felt no remorse.
        james.takeSnowGlobes(snowGlobes);

        // James surveyed his haul with quiet satisfaction.
        // ACU would never know.
        james.printKnapsack();
    }
}
