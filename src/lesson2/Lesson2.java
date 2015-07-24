/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */
package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson2 {
    private static final String WORD_REGEXP = "[- .:,]+";
    private static final String FILE_PATH  = "C:\\Users\\marsilva\\git\\java8\\src\\lesson2\\";
    
    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws java.io.IOException
     */
    public void runExercises() throws IOException {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
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
        System.out.println("Running exercise 6 solution...");
        exercise6();
        System.out.println("Running exercise 7 solution...");
        exercise7();
    }

    /**
     * Exercise 1
     *
     * Create a new list with all the strings from original list converted to lower case and print them out.
     */
    private void exercise1() {
        List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        /* YOUR CODE HERE */
        // 1
        list.stream()
                .map(s -> s.toLowerCase())
                .collect(Collectors.toList());
         System.out.println(list);

         // 2
         list.stream()
         .map(String::toLowerCase)
         .collect(Collectors.toList());
         System.out.println(list);

         // 3
         list.stream()
         .map(String::toLowerCase)
         .collect(Collectors.toList())
         .forEach(System.out::println);
    }

    /**
     * Exercise 2
     *
     * Modify exercise 1 so that the new list only contains strings that have an odd length
     */
    private void exercise2() {
        List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        /* YOUR CODE HERE */
        list.stream()
                .filter(n -> n.length() % 2 != 0)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * Exercise 3
     *
     * Join the second, third and forth strings of the list into a single string, where each word is separated by a
     * hyphen (-). Print the resulting string.
     */
    private void exercise3() {
        List<String> list = Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

        /* YOUR CODE HERE */
        list.stream()
                .skip(1)
                .limit(3)
                .collect(Collectors.joining("-"));
        System.out.println(list);
    }

    /**
     * Exercise 4
     *
     * Count the number of lines in the file using the BufferedReader provided
     */
    private void exercise4() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH + "SonnetI.txt"), StandardCharsets.UTF_8)) {
            /* YOUR CODE HERE */
            System.out.println("number of lines: " + reader.lines().count());
        }
    }

    /**
     * Exercise 5
     *
     * Using the BufferedReader to access the file, create a list of words with no duplicates contained in the file.
     * Print the words.
     * 
     * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
     */
    private void exercise5() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH + "SonnetI.txt"), StandardCharsets.UTF_8)) {
            /* YOUR CODE HERE */
            List<String> list = reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(list);
        }
    }

    /**
     * Exercise 6
     *
     * Using the BufferedReader to access the file create a list of words from the file, converted to lower-case and
     * with duplicates removed, which is sorted by natural order. Print the contents of the list.
     */
    private void exercise6() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH + "SonnetI.txt"), StandardCharsets.UTF_8)) {
            /* YOUR CODE HERE */
            List<String> list = reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .map(s -> s.toLowerCase())
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(list);
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    private void exercise7() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH + "SonnetI.txt"), StandardCharsets.UTF_8)) {
            /* YOUR CODE HERE */
            // 1
            List<String> list = reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .map(s -> s.toLowerCase())
                    .distinct()
                    .sorted((s1,s2) -> s1.length() - s2.length())
                    .collect(Collectors.toList());
            System.out.println(list);
        }
        
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH + "SonnetI.txt"), StandardCharsets.UTF_8)) {
            /* YOUR CODE HERE */
            // 2
            Pattern pat = Pattern.compile(WORD_REGEXP);
            List<String> list2 = reader.lines()
                    .flatMap(line -> pat.splitAsStream(line))
                    .map(s -> s.toLowerCase())
                    .distinct()
                    .sorted((s1,s2) -> s1.length() - s2.length())
                    .collect(Collectors.toList());
            System.out.println(list2);            
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH + "SonnetI.txt"), StandardCharsets.UTF_8)) {
            /* YOUR CODE HERE */
            // 3
            Pattern pat = Pattern.compile(WORD_REGEXP);
            List<String> list3 = reader.lines()
                    .flatMap(pat::splitAsStream)
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted((s1,s2) -> s1.length() - s2.length())
                    .collect(Collectors.toList());
            System.out.println(list3); 
        }
    }

    /**
     * Main entry point for application
     *
     * @param args
     *            the command line arguments
     * @throws IOException
     *             If file access does not work
     */
    public static void main(String[] args) throws IOException {
        Lesson2 lesson = new Lesson2();
        lesson.runExercises();
    }
}
