package threadingone;

public class Visitility {
  public static void main(String[] args) throws InterruptedException {
    boolean [] stop = { false };
    
    new Thread(()->{
      System.out.println("Starting....");
      while (!stop[0])
        ;
      System.out.println("Stopping....");
    }).start();
    
    Thread.sleep(2_000);
    stop[0] = true;
    System.out.println("Main exiting...");
  }
}
