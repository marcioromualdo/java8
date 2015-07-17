/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 1 homework
 */
package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson1 {
    /**
     * Run the exercises to ensure we got the right answers
     */
    public void runExercises() {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
        System.out.println("Running exercise 1 solution...");
        exercise1();
        System.out.println("Running exercise 2 solution...");
        exercise2();
        System.out.println("Running exercise 3 solution...");
        exercise3();
        System.out.println("Running exercise 4 solution...");
        exercise4();
        System.out.println("Running exercise 5 solution...");
        exercise5();
    }

    /**
     * All exercises should be completed using Lambda expressions and the new methods added to JDK 8 where appropriate.
     * There is no need to use an explicit loop in any of the code. Use method references rather than full lambda
     * expressions wherever possible.
     */
    /**
     * Exercise 1
     *
     * Create a string that consists of the first letter of each word in the list of Strings provided.
     */
    private void exercise1() {
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

        /* YOUR CODE HERE */
        // 1
        StringBuilder sb1 = new StringBuilder();
        Consumer<String> consumer = s -> sb1.append(s.charAt(0));
        list.forEach(consumer);
        System.out.println(sb1);

        // 2
        StringBuilder sb2 = new StringBuilder();
        list.forEach(p -> sb2.append(p.charAt(0)));
        System.out.println(sb2);

        // 3 
        list.forEach(s -> System.out.print(s.charAt(0)));
        System.out.println();

        // 4
        list.stream()
                .map(s -> s.charAt(0))
                .forEach(System.out::print);
        System.out.println();;
    }
    
    private static String firstChar(String s) {
        return String.valueOf(s.charAt(0));
    }

    /**
     * Exercise 2
     *
     * Remove the words that have odd lengths from the list.
     */
    private void exercise2() {
        List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "test"));

        /* YOUR CODE HERE */
        // 1
        Predicate<String> isEvenLength = s -> s.length() % 2 == 0;
        Predicate<String> isOddLength = isEvenLength.negate();
        list.removeIf(isOddLength);
        System.out.println(list);

        // 2
        System.out.println(list.stream()
             // .filter(s -> s.length() % 2 == 0)
                .filter(Lesson1::isEvenString) 
                .collect(Collectors.joining(", ")));

        // 3
        list.stream()
                .filter(s -> s.length() % 2 == 0)
                .forEach(System.out::println);
    }

    private static boolean isEvenString(String s) {
        return s.length() % 2 == 0;
    }

    /**
     * Exercise 3
     *
     * Replace every word in the list with its upper case equivalent.
     */
    private void exercise3() {
        List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        /* YOUR CODE HERE */
        // 1
        list.replaceAll(s-> s.toUpperCase());
        System.out.println(list);

        // 2
        list.replaceAll(String::toUpperCase);
        System.out.println(list);

        // 3
        list.replaceAll(String::toUpperCase);
        list.stream().forEach(System.out::println);
    }

    /**
     * Exercise 4
     *
     * Convert every key-value pair of the map into a string and append them all into a single string, in iteration
     * order.
     */
    private void exercise4() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);
        
        /* YOUR CODE HERE */
        // 1
        StringBuilder sb = new StringBuilder();
        map.keySet().forEach(s -> sb.append(s).append(map.get(s)));
        System.out.println(sb);

        // 2
        StringBuilder sb2 = new StringBuilder();
        map.forEach((x, y) -> sb2.append(x).append(y));
        System.out.println(sb2);

        // 3
        String s = map.entrySet().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(s);
    }

    /**
     * Exercise 5
     *
     * Create a new thread that prints the numbers from the list.
     */
    private void exercise5() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /* YOUR CODE HERE */
        // 1
        Runnable r1 = () -> list.forEach(s -> System.out.print(s + " "));
        r1.run();
        System.out.println();
        
        // 2
        Runnable r2 = () -> list.forEach(System.out::print);
        r2.run();
        System.out.println();

        // 3
        new Thread(() -> { 
            list.forEach(System.out::print); 
            System.out.println(); 
        }).start();
    }

    /**
     * Main entry point for application
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Lesson1 lesson = new Lesson1();
        lesson.runExercises();
    }
}
