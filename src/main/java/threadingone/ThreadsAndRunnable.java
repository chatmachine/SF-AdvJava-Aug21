package threadingone;

class MyJob implements Runnable {
  private int i = 0;
  @Override
  public void run() {
    for (; i < 10_000 ; i++) {
      System.out.println(Thread.currentThread().getName() + " i is " + i);
    }
  }
}

public class ThreadsAndRunnable {
  public static void main(String[] args) {
    MyJob j = new MyJob();
    Thread t1 = new Thread(j);
    Thread t2 = new Thread(j);
    t1.start();
    t2.start();
    System.out.println("Main exiting...");
  }
}
