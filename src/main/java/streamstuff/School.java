package streamstuff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class School {
  public static String gradeLetterOfStudent(Student s) {
    float gpa = s.getGpa();
    if (gpa > 3.8) return "A";
    if (gpa > 3.6) return "B";
    if (gpa > 3.0) return "C";
    return "D";
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

        school.stream()
        .collect(
            Collectors.groupingBy(School::gradeLetterOfStudent,
                Collectors.mapping(Student::getName, Collectors.joining(", "))
            )
        )
        .entrySet().stream()
        .forEach(System.out::println);
  }
}
