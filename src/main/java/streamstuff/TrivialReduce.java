package streamstuff;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TrivialReduce {
  public static void main(String[] args) {
    IntStream.iterate(1, v -> v + 1)
        .limit(10)
        .reduce((a,b)-> a + b)
        .ifPresent(System.out::println);
        
//        .peek(x->System.out.println("peeking " + x))
//        .forEach(System.out::println)
        ;
  }
}
