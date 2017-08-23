package streamstuff;

import java.util.Optional;

class Breakable {
  private String value;

  public Breakable() {
    this.value = "DEFAULT from constructor";
  }
  
  public Breakable(String value) {
    this.value = value;
  }
  
  public Breakable computeSomething() {
    if (Math.random() > 0.5) {
      return new Breakable(value + " something");
    } else {
      return null;
    }
  }

  public Breakable computeOtherThing() {
    if (Math.random() > 0.5) {
      return new Breakable(value + " otherthing");
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    return "Breakable{" + "value=" + value + '}';
  }
}

public class OptStuff {
  public static void main(String[] args) {
    Breakable b = new Breakable("init");
    
    b = b.computeOtherThing();
    if (b != null) {
      b = b.computeSomething();
    }
    System.out.println("> " + b);
    
    System.out.println("--------------------------");
    Optional<Breakable> ob = Optional.of(new Breakable("init2"));
    Breakable result = ob
//        .map(b1->b1.computeSomething())
        .map(Breakable::computeSomething)
//        .map(b1->b1.computeOtherThing())
        .map(Breakable::computeOtherThing)
        .orElse(new Breakable());
//        .ifPresent(b1->System.out.println("> " + b1));

    System.out.println(">> " + result);
  }
}
