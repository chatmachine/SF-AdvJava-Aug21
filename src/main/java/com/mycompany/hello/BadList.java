package com.mycompany.hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BadList {
  public static void breakAList(List l) {
    l.add(new Date());
  }
  
  public static void main(String[] args) {
    List<String> ls = Collections.checkedList(
        new ArrayList<>(), String.class);
    ls.add("Fred");
    ls.add("Jim");
    breakAList(ls);
    for (String s : ls) {
      System.out.println("> " + s);
    }
  }
}
