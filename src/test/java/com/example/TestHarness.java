package com.example;

/**
 * A test utility that uses reflection to invoke private methods at runtime.
 *
 * <p>In normal Java code, private methods cannot be called from outside their class. 
 * However, the reflection API allows us to bypass this restriction which is useful 
 * in testing when you need to inspect internal state without exposing it in the public API.
 *
 * <p>To protect against misuse, this harness will only invoke methods that have been
 * explicitly marked with the annotation that you create. If the annotation is missing, 
 * an exception should be thrown.
 */
public class TestHarness {
    public static <T> T invoke(Object target, String methodName, Class<T> returnType) {
        // make this do something
        // or dont, its up to you
        return null;
    }
}
