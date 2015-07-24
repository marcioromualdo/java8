/**
 * 
 * JDK 8 MOOC Lesson 1 Quiz
 */
package lesson1;

import java.nio.Buffer;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * @author Marcio Romualdo
 */
public class Quiz1 {
    
    public static void main(String[] args) {
        
        BiFunction<Buffer, Integer, Buffer> f = (Buffer b, Integer n) -> b.position(n);
        Function<Buffer, Integer> f2 = b -> b.position();
        
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        list1.replaceAll(Integer::signum);
        list1.replaceAll(n -> Integer.signum(n));
    }
}
