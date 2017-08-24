package threadingone;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Thing {
  private String s1;
  private String s2;

  public void setS1(String s1) {
    this.s1 = s1;
  }

  public void setS2(String s2) {
    this.s2 = s2;
  }

  public boolean isConsistent() {
    return s1.equals(s2);
  }
}


public class ProdRunnable implements Runnable {
  
}

public class ProdCons {
  public static void main(String[] args) {
    BlockingQueue<Thing> q = new ArrayBlockingQueue<>(10);
  }
}
