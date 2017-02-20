package Multithreading.Java8;

//import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.number.IsCloseTo.*;

public class Tester1 {
  public static void main(String[] args) {
    String message1 = "Sequential sum of %,d numbers is %,.4f.";
    String message2 = "Parallel sum of   %,d numbers is %,.4f.";
    for (int i=3; i<9; i++) {
      int arraySize = (int)Math.pow(10, i);
      double[] nums = MathUtils.randomNums1(arraySize);

      TimingUtils.timeOp(new Op() {   // () -> String.format(message1, arraySize, sum)
        @Override
        public String runOp() {
          double sum = MathUtils.arraySum(nums);
          return(String.format(message1, arraySize, sum));
        }
      });

      TimingUtils.timeOp(new Op() {
        @Override
        public String runOp() {
          double sum = MathUtils.arraySumParallel(nums);
          return(String.format(message2, arraySize, sum));
        }
      });
    }
  }
  
  /** JUnit test routine. Uses the extended closeTo method of IsCloseTo
   *  instead of the simpler equalTo method of CustomMatcher,
   *  because reordering addition for doubles does not always yield
   *  exactly the same answer due to roundoff error.
   */
//  @Test
//  public void testSums() {
//    for (int i=1; i<5; i++) {
//      int arraySize = (int)Math.pow(10, i);
//      double[] nums = MathUtils.randomNums1(arraySize);
//      double sum1 = MathUtils.arraySum(nums);
//      double sum2 = MathUtils.arraySumParallel(nums);
//      assertThat(sum1, is(closeTo(sum2, 0.000001)));
//    }
//  }
}

