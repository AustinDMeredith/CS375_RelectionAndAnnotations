## Assignment: Custom Annotations & Reflection in Java

## Overview

In this assignment, you will implement a custom Java annotation and use **reflection** to access private methods during testing without modifying the visibility of those methods in the source code.

This mirrors a real-world pattern. Sometimes you want to verify internal state in a test without exposing it in your public API.

Clone this repo and push your solution another repo you made. (please don't push to mine)

---

## Background

Java's **reflection API** allows you to inspect and interact with classes, methods, and fields at runtime, even private ones. Combined with **custom annotations**, you can build a testing harness that selectively exposes private methods that have been explicitly marked as safe to access in tests.

You will be working with a James class, a professor with a knapsack; a love for HCI and Lord of The Rings; and a deeply concerning snow globe addiction. James collects snow globes greedily by value-to-weight ratio, because even an HCI professor knows a good optimization problem when he sees one. His internal getKnapsack() method is private and Homer.inc's legal team has been very firm on this, but you still need to verify its contents in your tests.

---

## Your Task

### Step 1 — Create the `@ExposeForTesting` Annotation

Create a file `ExposeForTesting.java` in `src/main/java/com/example/`. This annotation should:

- Be applicable to **methods** only (`@Target`)
- Be available at **runtime** (`@Retention`) so reflection can detect it

### Step 2 — Annotate `getKnapsack()` in `James`

The `James` class has a private method:

```java
private List<SnowGlobe> getKnapsack() { return knapsack; }
```

Apply your `@ExposeForTesting` annotation to it. **Do not change its visibility.**

### Step 3 — Create the `TestHarness` Utility

Add Functionality to the `TestHarness.java` class with a static method:

```java
public static <T> T invoke(Object target, String methodName, Class<T> returnType)
```

This method should:

1. Use reflection to find the named method on the target object
2. Check that it is annotated with `@ExposeForTesting`. If not, throw an `IllegalAccessException`
3. Set the method accessible via reflection
4. Invoke it and return the result cast to `returnType`

### Step 4 — Use `TestHarness` in Your Tests

Update `JamesTest` to use `TestHarness.invoke(...)` instead of calling `getKnapsack()` directly. Your tests should still pass.

---

## File Structure

```
src/
├── main/java/com/example/
│   ├── ExposeForTesting.java   ← you complete this
│   ├── James.java              ← you annotate getKnapsack()
│   ├── SnowGlobe.java
│   └── Main.java
└── test/java/com/example/
    ├── JamesTest.java          ← you update this
    └── TestHarness.java        ← you complete this
```

---

## Requirements

- `getKnapsack()` in `James` must remain **private**
- `@ExposeForTesting` must retain during runtime and only target methods
- `TestHarness` must **reject** unannotated private methods with an exception
- Any warnings should should be suppressed with @SuppressWarnings("unchecked")
- All four tests in `JamesTest` must pass via `mvn test`

---

## Hints

- `Class.getDeclaredMethod(String name)` finds methods regardless of visibility
- `method.setAccessible(true)` bypasses the private modifier at runtime
- `method.isAnnotationPresent(ExposeForTesting.class)` checks for your annotation
- `method.invoke(targetClass)` calls the method on the given object instance. For methods with no parameters, no additional arguments are needed
- `returnType.cast(object)` converts the raw Object returned by method.invoke() into the expected type
- Wrap checked exceptions from reflection in `RuntimeException` for cleaner test code

---

## Running Your Tests

```bash
mvn test
```
