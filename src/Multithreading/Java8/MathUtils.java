package Multithreading.Java8;

import java.math.*;
import java.util.concurrent.*;

public class MathUtils {
  private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool(4);

  public static double arraySum(double[] nums, 
                                int lowerIndex, int upperIndex) {
    double sum = 0;
    for(int i=lowerIndex; i<=upperIndex; i++) {
      sum += nums[i];
    }
    return(sum);
  }

  public static double arraySum(double[] nums) {
    return(arraySum(nums, 0, nums.length-1));
  }

  public static Double arraySum(Double[] nums, 
                                int lowerIndex, int upperIndex) {
    double sum = 0;
    for(int i=lowerIndex; i<=upperIndex; i++) {
      sum += nums[i];
    }
    return(sum);
  }
  
  public static Double arraySum(Double[] nums) {
    return(arraySum(nums, 0, nums.length-1));
  }
  
  public static Double arraySumParallel(double[] nums) {
    return(FORK_JOIN_POOL.invoke(new ParallelArraySummer(nums, 0, nums.length-1)));
  }
  
//  public static Double arraySumParallel(Double[] nums) {
//    int parallelSizeCutoff = 1000;
//    SequentialArrayProcessor<Double,Double> smallSizeProcessor =
//      new ArrayAdder();
//    Combiner<Double> valueCombiner = new Adder();
//    ForkJoinPool pool = ParallelArrayProcessor.FORK_JOIN_POOL;
//    ParallelArrayProcessor<Double,Double> processor =
//      new ParallelArrayProcessor<>(nums, parallelSizeCutoff,
//                                   smallSizeProcessor, valueCombiner,
//                                   0, nums.length-1);
//    return(pool.invoke(processor));
//  }
//
//  public static double smallestTransformedValue
//        (Double[] nums,
//         Funct<Double,Double> transformer,
//         int lowerIndex, int upperIndex) {
//    double smallest = Double.MAX_VALUE;
//    for (int i=lowerIndex; i<=upperIndex; i++) {
//      smallest = Math.min(smallest,
//                          transformer.computeValue(nums[i]));
//    }
//    return(smallest);
//  }

//  public static double smallestFancyValue(Double[] nums,
//                                          int lowerIndex,
//                                          int upperIndex) {
//    Funct<Double,Double> slowFunct = new SlowFunct();
//    return(smallestTransformedValue(nums, slowFunct,
//                                    lowerIndex, upperIndex));
//  }
  
//  public static double smallestFancyValue(Double[] nums) {
//    return(smallestFancyValue(nums, 0, nums.length-1));
//  }
  
//  public static double smallestFancyValueParallel(Double[] nums) {
//    int parallelSizeCutoff = 500;
//    SequentialArrayProcessor<Double,Double> smallSizeProcessor =
//      new FancyArrayMinimizer();
//    Combiner<Double> valueCombiner = new Minimizer();
//    ForkJoinPool pool = ParallelArrayProcessor.FORK_JOIN_POOL;
//    ParallelArrayProcessor<Double,Double> processor =
//      new ParallelArrayProcessor<>(nums, parallelSizeCutoff,
//                                   smallSizeProcessor, valueCombiner,
//                                   0, nums.length-1);
//    return(pool.invoke(processor));
//  }
  
  /** Finds 100-digit primes and stores them in the supplied array. */
  
//  public static void findPrimes(BigInteger[] primes,
//                                int lowerIndex,
//                                int upperIndex) {
//    for (int i=lowerIndex; i<=upperIndex; i++) {
//      primes[i] = Primes.findPrime(100);
//    }
//  }
//
//  public static void findPrimes(BigInteger[] primes) {
//    findPrimes(primes, 0, primes.length-1);
//  }
//
//  public static void findPrimesParallel(BigInteger[] primes) {
//    int parallelSizeCutoff = 2;
//    SequentialArrayProcessor<BigInteger,Void> smallSizeProcessor =
//      new PrimeStorer();
//    Combiner<Void> valueCombiner = new Ignorer();
//    ForkJoinPool pool = ParallelArrayProcessor.FORK_JOIN_POOL;
//    ParallelArrayProcessor<BigInteger,Void> processor =
//      new ParallelArrayProcessor<>(primes, parallelSizeCutoff,
//                                   smallSizeProcessor, valueCombiner,
//                                   0, primes.length-1);
//    pool.invoke(processor);
//  }

  public static double[] randomNums1(int length) {
    double[] nums = new double[length];
    for(int i=0; i<length; i++) {
      nums[i] = Math.random();
    }
    return(nums);
  }
  
  public static Double[] randomNums2(int length) {
    Double[] nums = new Double[length];
    for(int i=0; i<length; i++) {
      nums[i] = Math.random();
    }
    return(nums);
  }
  
  public static double slowFunction(double d) {
    return(Math.sqrt(Math.sqrt(d*Math.PI) +
                     Math.sin(d) + Math.cos(d) + 
                     Math.sin(d) + Math.cos(d) + 
                     Math.sin(d) + Math.cos(d) + 
                     Math.cbrt(d) + Math.sqrt(d) +
                     Math.exp(Math.cbrt(d))));
  }
  
  private MathUtils() {} // Uninstantiatable class: only static methods
}
