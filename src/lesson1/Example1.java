package lesson1;

public class Example1 {

    @FunctionalInterface
    public interface TestInterface {
         public abstract void text();
    }

    public static void print() {
        TestInterface example = () -> System.out.println("Test");
        example.text();
    }

    public static void print2() {
        Runnable r = () -> System.out.println("Test");
        r.run();
    }

    public static void main(String[] args) {
        print();
        print2();
    }
}
