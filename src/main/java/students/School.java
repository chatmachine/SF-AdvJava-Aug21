package students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class School {
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
    
  }
}
