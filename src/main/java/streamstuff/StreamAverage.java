package streamstuff;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

class Average {

  private double sum;
  private long count;

  public Average() {
  }

  public void include(double v) {
    sum += v;
    count++;
  }

  public void merge(Average a) {
    sum += a.sum;
    count += a.count;
  }

  public double get() {
    return sum / count;
  }

  @Override
  public String toString() {
    return "Average{" + "sum=" + sum + ", count=" + count
        + " average= " + get() + '}';
  }

}

public class StreamAverage {

  public static void main(String[] args) {
    long[] count = {0};
    long start = System.nanoTime();
    System.out.println(
        DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
            .parallel()
            .limit(1_000_000_000)
            .peek(x-> {count[0]++;})
            .map(Math::sin)
            .collect(Average::new,
                Average::include,
                Average::merge
            )
    //        .collect(() -> new Average(), 
    //            (b, d) -> b.include(d), 
    //            (b1, b2) -> b1.merge(b2))
    );
    long end = System.nanoTime();
    System.out.printf("Time was %12.9f\n", (end - start)/1_000_000_000.0);
    System.out.println("count is " + count[0]);
  }
}
