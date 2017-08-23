package streamstuff;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

class Automobile {

  private int fuelLevel;
  private String name;
  private List<String> passengers;

  public Automobile(int fuelLevel, String name, String... passengers) {
    this.fuelLevel = fuelLevel;
    this.name = name;
    this.passengers = Arrays.asList(passengers);
  }

  public int getFuelLevel() {
    return fuelLevel;
  }

  public String getName() {
    return name;
  }

  public List<String> getPassengers() {
    return passengers;
  }

  @Override
  public String toString() {
    return "Automobile{" + "fuelLevel=" + fuelLevel + ", name=" + name + ", passengers=" + passengers + '}';
  }
}

public class StreamStuff {

  public static Stream<String> pairCarNameWithPassengers(Automobile x) {
    String carName = x.getName();
    return x.getPassengers().stream().map(p -> carName + " : " + p);
  }

  public static void main(String[] args) {
    List<Automobile> fleet = Arrays.asList(
        new Automobile(8, "Edsel", "Tom", "Dick", "Harry"),
        new Automobile(18, "Hummer", "Arnold"),
        new Automobile(14, "Taurus", "Sue", "Alan")
    );

    Function<Automobile, Automobile> upperCaseCarName
        = x -> new Automobile(x.getFuelLevel(),
            x.getName().toUpperCase(),
            x.getPassengers().toArray(new String[0]));

//    Function<Automobile, Stream<String>> pairCarNameWithPassengers = 
//        x -> {
//          String carName = x.getName();
//          return x.getPassengers().stream().map(p-> carName + " : " + p);
//        };
    fleet.stream()
        .filter(x -> x.getFuelLevel() > 10)
        .map(upperCaseCarName)
        .flatMap(StreamStuff::pairCarNameWithPassengers)
        .forEach(System.out::println);
  }
}
