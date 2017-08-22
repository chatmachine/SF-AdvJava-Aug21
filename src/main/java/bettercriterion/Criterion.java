package bettercriterion;

public interface Criterion<E> {

  boolean test(E s);

  default Criterion<E> not() {
    return x -> !this.test(x);
  }
  
  default Criterion<E> and(final Criterion<E> other) {
//    other = null;
    return x -> this.test(x) && other.test(x);
  }
  
  default Criterion<E> or(Criterion<E> other) {
    return x -> this.test(x) || other.test(x);
  }

  static <E> Criterion<E> and(Criterion<E> a, Criterion<E> b) {
    return s -> a.test(s) && b.test(s);
  }

}
