package lesson2;

import java.util.stream.IntStream;

public class SumPairs {

    public static void main(String... args) {
        System.out.println(
                IntStream.rangeClosed(2, Integer.valueOf(args[0]))
                .filter(n -> n % 2 == 0)
                .sum()
        );
    }
}
