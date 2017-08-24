package threadingone;

import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallableJob implements Callable<String> {
  private static int nextId = 0;
  private int myId = nextId++;
  
  public String call() throws Exception {
    System.out.println("Job " + myId + " starting");
    
    try {
      Thread.sleep((int)((Math.random() * 1000) + 1000));
    } catch (InterruptedException ex) {
      System.out.println("Interrupted, shutting self down");
      throw ex;
    }
    if (Math.random() > 0.8) {
      System.out.println("DB trouble....");
      throw new SQLException("DB troubles!");
    }
    
    System.out.println("Job " + myId + " ending");
    return "Job " + myId;
  }
}

public class ExecutorExample {
  public static void main(String[] args) throws Throwable {
    final int JOB_COUNT = 8;
    ExecutorService es = Executors.newFixedThreadPool(2);
    @SuppressWarnings("unchecked")
    Future<String>[] handles = new Future[JOB_COUNT];
    for (int i = 0; i < JOB_COUNT; i++) {
      handles[i] = es.submit(new MyCallableJob());
    }
    System.out.println("All jobs submitted");
    
    Thread.sleep(100);
    handles[1].cancel(true);
    
    for (int i = 0; i < JOB_COUNT; i++) {
      try {
        String rv = handles[i].get();
        System.out.println("Job returned " + rv);
      } catch (CancellationException ce) {
        System.out.println("Job " + i + " was canceled");
      } catch (ExecutionException e) {
        System.out.println("Job " + i + " sent us " + e.getClass().getName()
            + " cause is " + e.getCause().getClass().getName()
            + " message is " + e.getCause().getMessage());
      }
    }
    System.out.println("All finished");
    es.shutdown();
    System.out.println("Executor service shutdown...");
  }
}
