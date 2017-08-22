package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface StudentCriterion {
  boolean test(Student s);
}

interface Criterion<E> {
  boolean test(E s);
}

public class School {
  public static Comparator<Student> inverse(Comparator<Student> cs) {
    return (s1, s2) -> cs.compare(s2, s1);
  }
  
  public static List<Student> getStudents(
      Iterable<Student> in, StudentCriterion criterion) {
    List<Student> rv = new ArrayList<>();
    
    for (Student s : in) {
      if (criterion.test(s)) {
        rv.add(s);
      }
    }
    return rv;
  }
  
  public static <E> List<E> filter(
      Iterable<E> in, Criterion<E> criterion) {
    List<E> rv = new ArrayList<>();
    
    for (E s : in) {
      if (criterion.test(s)) {
        rv.add(s);
      }
    }
    return rv;
  }
  
  public static void main(String[] args) {
    List<Student> school = new ArrayList<>();
    school.add(Student.getFromeNameGpaCourses(
        "Fred", 3.2F, "Math", "Physics"));
    school.add(Student.getFromeNameGpaCourses(
        "Sheila", 3.9F, "Math", "Physics", "Astrophysics"));
    school.add(Student.getFromeNameGpaCourses(
        "Jim", 2.9F, "Art"));
    for (Student s : school) {
      System.out.println("> " + s);
    }
    
    System.out.println("-----------------------");
//    Collections.sort(roster, 
//        new StudentNameComparator());
    school.sort(Student.getNameComparator());
    for (Student s : school) {
      System.out.println("> " + s);
    }
    System.out.println("-----------------------");
   
    school.sort(
        (s1,s2)->Float.compare(s1.getGpa(),s2.getGpa())
    );
    for (Student s : school) {
      System.out.println("> " + s);
    }
    System.out.println("-----------------------");
    
    school.sort(inverse(Student.getNameComparator()));
    for (Student s : school) {
      System.out.println("> " + s);
    }
    System.out.println("Smart: -----------------------");
    List<Student> selected = getStudents(school, s->s.getGpa() > 3);
    for (Student s : selected) {
      System.out.println("> " + s);
    }
    System.out.println("Enthusiastic: -----------------------");
    selected = getStudents(school, s->s.getCourses().size() > 2);
    for (Student s : selected) {
      System.out.println("> " + s);
    }
    System.out.println("Smart: -----------------------");
    selected = filter(school, s->s.getGpa() > 3);
    for (Student s : selected) {
      System.out.println("> " + s);
    }
    System.out.println("Enthusiastic: -----------------------");
    selected = filter(school, s->s.getCourses().size() > 2);
    for (Student s : selected) {
      System.out.println("> " + s);
    }
    
    System.out.println("Long strings: -----------------------");
    List<String> ls = Arrays.asList("Fred", "Jim", "Orinoco", "Wafflesprocket");
    List<String> longS = filter(ls, s->s.length() > 4);
    for (String s : longS) {
      System.out.println("> " + s);
    }
    
    
  }
}
