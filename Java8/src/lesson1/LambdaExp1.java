package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.ToDoubleFunction;

public class LambdaExp1 {
    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Student> students = generateStudents();

        /*
        long startTime = System.currentTimeMillis();
        System.out.println(proceduralExecute(students));
        long finishTime = System.currentTimeMillis();
        System.out.println("Procedural: " + (finishTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(functionalLambda(students));
        finishTime = System.currentTimeMillis();
        System.out.println("Lambda: " + (finishTime - startTime));
        */

        measure("Procedural: ", students, LambdaExp1::proceduralExecute);
        measure("Lambda: ", students, LambdaExp1::functionalLambda);
    }

    private static double proceduralExecute(List<Student> students) {
        double max = 0.0;
        for (Student s : students) {
            if (s.getGradYear() == 2011) {
                if (s.getGrade() > max) {
                    max = s.getGrade();
                }
            }
        }
        return max;
    }

    private static double functionalLambda(List<Student> students) {
        OptionalDouble max = students.parallelStream()
                .filter(s -> s.getGradYear() == 2011)
                .mapToDouble(s -> s.getGrade()).max();

        return max.getAsDouble();
    }

    private static ArrayList<Student> generateStudents() {
        ArrayList<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            int year = random.nextInt(16) + 2000;
            double grade = random.nextDouble() * 100;

            students.add(new Student(year, grade));
        }

        return students;
    }

    private static void measure(String title, List<Student> students, ToDoubleFunction<List<Student>> function) {

        long best = Long.MAX_VALUE;

        double max = 0;
        for (int i = 0; i < 10; ++i) {

            long start = System.nanoTime();

            max = function.applyAsDouble(students);

            long duration = System.nanoTime() - start;

            if (duration < best) {
                best = duration;
            }
        }

        System.out.println("max=" + max);
        System.out.println(title + best / 1000_000);

    }
}
