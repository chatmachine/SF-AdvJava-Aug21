package students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface StudentCriterion {
  boolean test(Student s);
}

public class School {
  public static Comparator<Student> inverse(Comparator<Student> cs) {
    return (s1, s2) -> cs.compare(s2, s1);
  }
  
  public static List<Student> getSmartStudents(
      Iterable<Student> in) {
    List<Student> rv = new ArrayList<>();
    
    for (Student s : in) {
      if (s.getGpa() > 3.4) {
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
   
  }
}
