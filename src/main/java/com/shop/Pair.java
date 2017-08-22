package com.shop;

public class Pair<E extends Sized & Colored> {

  private E left;
  private E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public E getLeft() {
    return left;
  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public <F> void setRight(E right) {
    this.right = right;
  }

  public boolean isMatched() {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
  
  // not allowed to access instance type variables in static context
//  public static boolean areMatched(E l, E r) {
//    return true;
//  }
  
  // local generic type variables are local, so E here is not the same
  // E as declared for the class. Using a different variable might make
  // this sourcecode less confusing, however!... 
  public static <E extends Sized & Colored> boolean areMatched(E left, E right) {
    return left.getSize() == right.getSize()
        && left.getColor() == right.getColor();
  }
  
  @Override
  public String toString() {
    return "Pair{" + "left=" + left + ", right=" + right + '}';
  }

}
