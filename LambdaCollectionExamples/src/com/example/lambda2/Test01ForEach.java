package com.example.lambda2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.example.lambda1.Person;

/**
 *
 * @author MikeW
 */
public class Test01ForEach {
  
  public static void main(String[] args) {
    
    List<Person> pl = Person.createShortList();
    
    System.out.println("\n=== Western Phone List ===");
    pl.forEach( p -> p.printWesternName() );
    
    System.out.println("\n=== Eastern Phone List ===");
    pl.forEach(Person::printEasternName);
    
    System.out.println("\n=== Custom Phone List ===");
    pl.forEach(p -> { System.out.println(p.printCustom(r -> "Name: " + r.getGivenName() + " EMail: " + r.getEmail())); });
    
  }

}
