/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author chand
 */
public class Streams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(" a stream fixed number of elements ");
        stream.forEach(p -> System.out.println(p + ","));

        stream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(" a stream on a array of elements ");
        stream.forEach(p -> System.out.println(p + " "));

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        stream = list.stream();
        List<Integer> evenNumbersList = stream.filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Event Number List  " + evenNumbersList);
        System.out.println(" a stream on a list of elements ");

        stream = list.stream();
        stream.forEach(p -> System.out.println(p));

        Stream<Integer> randomNumbers = Stream
                .generate(() -> (new Random()).nextInt(1000));

        System.out.println(" a stream on a random number of elements ");
        randomNumbers.limit(1000)
                .forEach(System.out::println);

        
        List<String> memberNames = new ArrayList<>();
memberNames.add("Amitabh");
memberNames.add("Shekhar");
memberNames.add("Aman");
memberNames.add("Rahul");
memberNames.add("Shahrukh");
memberNames.add("Salman");
memberNames.add("Yana");
memberNames.add("Lokesh");


memberNames.stream().filter((s) -> s.startsWith("A"))
                    .forEach(System.out::println);


memberNames.stream().filter((s) -> s.startsWith("A"))
                    .map(String::toUpperCase)
                    .forEach(System.out::println);                 


memberNames.stream().sorted()
                    .map(String::toUpperCase)
                    .forEach(System.out::println);


boolean matchedResult = memberNames.stream()
        .anyMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);
 
matchedResult = memberNames.stream()
        .allMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);
 
matchedResult = memberNames.stream()
        .noneMatch((s) -> s.startsWith("A"));
 
System.out.println(matchedResult);


Optional<String> reduced = memberNames.stream()
        .reduce((s1,s2) -> s1 + "#" + s2);
 
reduced.ifPresent(System.out::println);
        
        
        
        System.out.println(" \n\n EOP");
    }

}
