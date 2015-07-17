package com.example.lambda2;

import java.util.List;
import java.util.stream.Collectors;

import com.example.lambda1.Person;

/**
 *
 * @author MikeW
 */
public class Test03toList {
  
  public static void main(String[] args) {
    
    List<Person> pl = Person.createShortList();
    
    SearchCriteria search = SearchCriteria.getInstance();
    
    // Make a new list after filtering.
    List<Person> pilotList = pl
            .stream()
            .filter(search.getCriteria("allPilots"))
            .collect(Collectors.toList());
    
    System.out.println("\n=== Western Pilot Phone List ===");
    
    pilotList.forEach(Person::printWesternName); // or: pilotList.forEach( p -> p.printWesternName() );
  }

}
