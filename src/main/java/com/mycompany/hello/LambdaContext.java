package com.mycompany.hello;

import java.util.Comparator;

class X {
  public int length() {
    return 0;
  }
}
public class LambdaContext {

  public static void main(String[] args) {
    int x = 
        ((Comparator<String>)
        ((o1, o2) -> o1.length() - o2.length()))
        .compare(null, null);
  }
}
