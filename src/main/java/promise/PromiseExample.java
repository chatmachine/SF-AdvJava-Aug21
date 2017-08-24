package promise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromiseExample {
  public static void delay() {
    try {
      Thread.sleep((int)(Math.random() * 1000 + 1000));
    } catch (InterruptedException ex) {
    }
  }
  
  public static CompletableFuture<String> readKeyboard() {
    CompletableFuture<String> rv = new CompletableFuture<>();
    ForkJoinPool.commonPool().execute(()->{
      System.out.println("About to read from keyboard");
      delay();
      System.out.println("keyboard read....");
      rv.complete("thedatafile.txt");
    });
    return rv;
  }
  
  public static CompletableFuture<String> processData(String input) {
    CompletableFuture<String> rv = new CompletableFuture<>();
    ForkJoinPool.commonPool().execute(()->{
      System.out.println("About to read from file " + input);
      delay();
      System.out.println("File read completely...");
      rv.complete("The processing handled input from " + input +
          " and gave us a result");
    });
    return rv;
  }
  
  public static void main(String[] args) {
    readKeyboard()
        .thenCompose(PromiseExample::processData)
        .thenAccept(System.out::println)
//        .join()
        ;
    for (int i = 0; i < 6; i++) {
      System.out.println("tick...");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
      }
    }
    System.out.println("Main exited...");
  }
  
}
