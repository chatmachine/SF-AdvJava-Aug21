package com.shop;

import java.awt.Color;

public class TheShop {
  public static void main(String[] args) {
//    Pair<String> ps = new Pair<String>("Fred", "Jones");
//    Pair<String> ps = new Pair<String>("Fred", "Jones");
//    // this one "works" because of no typing
//    Pair<Date> pd = new Pair(new Date(), "Blah");

      Pair<Glove> gloves = 
          new Pair<>(new Glove(5, Color.RED), new Glove(5, Color.RED));
      Pair<Glove> gloves2 = 
          new Pair<>(new Glove(5, Color.BLUE), new Glove(5, Color.RED));
      
      Shoe l1 = new Shoe(3, Color.yellow);
      Shoe r1 = new Shoe(4, Color.yellow);
      Glove r2 = new Glove(4, Color.yellow);
      boolean m1 = Pair.<Shoe>areMatched(l1, r1);
      // deliberate assignment prevents degeneration to Object
//      boolean m1 = Pair.<Shoe>areMatched(l1, r2);
  }
}
