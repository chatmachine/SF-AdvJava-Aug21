package dynamic;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;

public class MyTestHarness {
  public static void main(String[] args) throws Throwable {
    Properties p = new Properties();
    p.load(new FileReader("toTest.properties"));
//    System.setSecurityManager(new SecurityManager());
    @SuppressWarnings("unchecked")
    Enumeration k = p.keys();
    while (k.hasMoreElements()) {
      String className = p.getProperty((String)(k.nextElement()));
      System.out.println("Class to load is " + className);
      Class c = Class.forName(className);
      Object obj = c.newInstance();
//      Method[] methods = c.getMethods(); // Inherited, butnot private
      Method[] methods = c.getDeclaredMethods();
      for (Method m : methods) {
        System.out.println("> " + m);
        RunMe annotation = m.getAnnotation(RunMe.class);
        if (annotation != null) {
          System.out.println("*** @RunMe");
          String value = annotation.value();
          int count = annotation.count();
          System.out.println("value " + value + " count " + count);
          m.setAccessible(true);
          m.invoke(obj);
        }
      }
    }

  }
}
