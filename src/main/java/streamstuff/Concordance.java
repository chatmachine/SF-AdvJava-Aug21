package streamstuff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {
  public static final Pattern WORD_BOUNDARY = Pattern.compile("\\W+");
  
  public static void main(String[] args) {
    try (Stream<String> input = 
        Files.lines(Paths.get("PrideAndPrejudice.txt"));) {
      
      input
          .flatMap(WORD_BOUNDARY::splitAsStream)
          .filter(s-> s.length() > 0)
          .map(String::toLowerCase)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
          .entrySet().stream()
//          .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
          .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
          .limit(200)
          .forEachOrdered(e-> System.out.printf("%20s : %5d\n", e.getKey(), e.getValue()));
          ;
//          .forEach(System.out::println);
    } catch (IOException ex) {
      Logger.getLogger(Concordance.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }
}
