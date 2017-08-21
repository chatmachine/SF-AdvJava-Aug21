package students;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public final class Student {

  private final String name;
  private final float gpa;
  private final Set<String> courses;

  private Student(String name, float gpa, Set<String> courses) {
    this.name = name;
    this.gpa = gpa;
    this.courses = courses;
  }

  public static Student getFromeNameGpaCourses(String name, float gpa,
      String... courses) {
    if (!(gpa >= 0 && gpa <= 4.0)) {
      throw new IllegalArgumentException("bad gpa " + gpa);
    }
    return new Student(name, gpa, Collections.checkedSet(
        new HashSet<>(Arrays.asList(courses)),
        String.class));
  }

  public String getName() {
    return name;
  }

  public float getGpa() {
    return gpa;
  }

  public Set<String> getCourses() {
    return Collections.unmodifiableSet(courses);
  }

  @Override
  public String toString() {
    return "Student{" + "name=" + name + ", gpa=" + gpa + ", courses=" + courses + '}';
  }

  private static Comparator<Student> nameComparator =
    (o1, o2)->o1.name.compareTo(o2.name);

//  private static Comparator<Student> nameComparator
//      = (Student o1, Student o2) -> {
//        return o1.getName().compareTo(o2.getName());
//      };

//  private static Comparator<Student> nameComparator =
////      new Comparator<Student>() {
//
////    @Override
//    /*public int compare*/
//      (Student o1, Student o2) -> {
//      System.out.println("lambda comparator...");
//      return o1.getName().compareTo(o2.getName());
//    }
//  /*}*/;
//  private static Comparator<Student> nameComparator =
////  private static class NameComparator implements 
//      new Comparator<Student>() {
//
//    @Override
//    public int compare(Student o1, Student o2) {
//      System.out.println("anonymous comparator...");
//      return o1.getName().compareTo(o2.getName());
//    }
//  };
      
  public static Comparator<Student> getNameComparator() {
    return nameComparator;
  }
  
//  private static Comparator<Student> nameComparator = new NameComparator();
//  public static Comparator<Student> getNameComparator() {
//    return nameComparator;
//  }
//  
//  private static class NameComparator implements Comparator<Student> {
//
//    @Override
//    public int compare(Student o1, Student o2) {
//      System.out.println("Inner comparator...");
//      return o1.getName().compareTo(o2.getName());
//    }
//
//  }
}
