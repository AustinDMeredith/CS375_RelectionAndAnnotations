package com.example;

/**
 * A custom annotation that marks a private method as accessible to {@link TestHarness}
 * during testing via reflection.
 *
 * <p>Your job is to implement this annotation. An annotation declaration looks similar
 * to an interface, but uses {@code @interface} instead of {@code interface}:
 * <pre>
 *   public @interface ExposeForTesting {}
 * </pre>
 * </p>
 *
 * <p>On its own, this does nothing. You will need to add two meta-annotations to
 * control how and when this annotation is available:
 *
 * <ul>
 *   <li>{@code @Retention} — controls when the annotation is visible. For reflection
 *       to detect it at runtime, you must make the annotation retain during runtime.</li>
 *   <li>{@code @Target} — controls what kinds of things can be annotated. Since we
 *       are annotating methods, you will need to make the annotation target methods.</li>
 * </ul>
 *
 * <p>Both are found in {@code java.lang.annotation} and will need to be imported.
 *
 * <p>Once implemented, this annotation can be applied to any private method:
 * <pre>
 *   {@literal @}ExposeForTesting
 *   private List{@literal <}SnowGlobe{@literal >} getKnapsack() { return knapsack; }
 * </pre>
 *
 * <p>{@link TestHarness#invoke(Object, String, Class)} will check for its presence
 * before invoking the method — if it is missing, access will be denied.
 *
 * @see TestHarness
 */
public @interface ExposeForTesting {}
