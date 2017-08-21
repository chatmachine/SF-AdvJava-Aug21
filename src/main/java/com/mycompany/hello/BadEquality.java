package com.mycompany.hello;

class Tire {
  private int width, diameter;

  public Tire(int width, int diameter) {
    this.width = width;
    this.diameter = diameter;
  }

  public boolean equals(Object o) {
//    if (!(o instanceof Tire)) return false;
    if (o.getClass() != Tire.class) return false;
    Tire other = (Tire)o;
    return this.width == other.width
        && this.diameter == other.diameter;
  }
  @Override
  public String toString() {
    return "Tire{" + "width=" + width + ", diameter=" + diameter + '}';
  }
}

class TruckTire extends Tire {
  private int loadRating;

  public TruckTire(int width, int diameter, int loadRating) {
    super(width, diameter);
    this.loadRating = loadRating;
  }

  @Override
  public String toString() {
    return "TruckTire{" + "loadRating=" + loadRating 
        + " " + super.toString() + '}';
  }

public boolean equals(Object o) {
//  if (!(o instanceof TruckTire)) return false;
  if (o.getClass() != TruckTire.class) return false;
  TruckTire other = (TruckTire)o;
  return this.loadRating == other.loadRating
      && super.equals(o);
}  
  
}
public class BadEquality {
  public static void main(String[] args) {
    Tire t1 = new Tire(175, 14);
    Tire t2 = new Tire(185, 15);
    Tire t3 = new Tire(175, 14);
    TruckTire tt1 = new TruckTire(175, 14, 10);
    
    System.out.println("t1.equals t2 " + t1.equals(t2));
    System.out.println("t1.equals t3 " + t1.equals(t3));
    System.out.println("t1.equals tt1 " + t1.equals(tt1));
    System.out.println("tt1.equals t1 " 
        + tt1.equals(t1));
        
  }
}
