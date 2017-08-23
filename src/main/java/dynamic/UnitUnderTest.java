package dynamic;

//@RunMe
public class UnitUnderTest {
//  @RunMe
  String value;
  
  @RunMe(count = 2)
  public void doStuff() {
    System.out.println("doing stuff");
  }
  
  @RunMe(value="Jim", count = 1)
  private void doMoreStuff() {
    System.out.println("doing more stuff");
  }
  
  public void dontTestThis() {
    System.out.println("shouldn't run this!");
  }
}

