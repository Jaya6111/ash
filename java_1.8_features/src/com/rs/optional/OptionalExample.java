package com.rs.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {
    public static void main(String[] args) {
        // Creating Optional
        Optional<String> nonNullOptional = Optional.of("Hello");
        Optional<String> nullableOptional = Optional.ofNullable(null);

        // Accessing Values
        String value1 = nonNullOptional.get();
        String value2 = nullableOptional.orElse("Default");

        // Conditional Actions
        nonNullOptional.ifPresent(val -> System.out.println("Value: " + val));

        // Chaining and Mapping
        Optional<String> mappedOptional = nonNullOptional.map(String::toUpperCase);
        Optional<Integer> flatMappedOptional = nonNullOptional.flatMap(s -> parse(s));

        // Conversion to Stream
        nonNullOptional.ifPresent(val -> Stream.of(val).forEach(System.out::println));
    }

    private static Optional<Integer> parse(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
