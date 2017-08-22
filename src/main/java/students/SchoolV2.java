package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchoolV2 {

  public static <E> Criterion<E> and(Criterion<E>... c) {
    System.out.println("In and function...");
    return s -> {
      for (Criterion<E> t : c) {
        if (!(t.test(s))) return false;
      }
      return true;
    };
  } 

//  public static <E> Criterion<E> and(Criterion<E> a, Criterion<E> b) {
//    System.out.println("In and function...");
//    return s -> a.test(s) && b.test(s);
//  }
  
//  public static <E> Criterion<E> and(Criterion<E> a, Criterion<E> b) {
//    System.out.println("In and function...");
//    return new Criterion<E>() {
//      @Override
//      public boolean test(E s) {
//        System.out.println("In created function...");
//        return a.test(s) && b.test(s);
//      }
//    };
//  }

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
        "Freddy", 3.7F, "Math", "Physics"));
    school.add(Student.getFromeNameGpaCourses(
        "Frederick", 3.8F, "Math", "Physics", "Chemistry", "Quantum Mechanics"));
    school.add(Student.getFromeNameGpaCourses(
        "Freidrich", 2.2F, "Math", "Physics", "Chemistry, Quantum Mechanics"));
    school.add(Student.getFromeNameGpaCourses(
        "Freud", 2.8F, "Math", "Physics", "Chemistry"));
    school.add(Student.getFromeNameGpaCourses(
        "Sheila", 3.9F, "Math", "Physics", "Astrophysics"));
    school.add(Student.getFromeNameGpaCourses(
        "Jim", 2.9F, "Art"));

    System.out.println("Smart: -----------------------");
    Criterion<Student> smart = s -> s.getGpa() > 3;
    List<Student> selected = filter(school, smart);
    for (Student s : selected) {
      System.out.println("> " + s);
    }
    System.out.println("Enthusiastic: -----------------------");
    Criterion<Student> enthusiastic = s -> s.getCourses().size() > 2;
    selected = filter(school, enthusiastic);
    for (Student s : selected) {
      System.out.println("> " + s);
    }

    System.out.println("Smart and Enthusiastic: -----------------------");
    selected = filter(school, and(smart, enthusiastic));
    for (Student s : selected) {
      System.out.println("> " + s);
    }

  }
}
