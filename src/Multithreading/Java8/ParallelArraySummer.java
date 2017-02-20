package Multithreading.Java8;

import java.util.concurrent.*;

public class ParallelArraySummer extends RecursiveTask<Double> {
  private static final int PARALLEL_CUTOFF = 1000;
  private double[] nums;
  private int lowerIndex, upperIndex;
  
  public ParallelArraySummer(double[] nums, int lowerIndex, int upperIndex) {
    this.nums = nums;
    this.lowerIndex = lowerIndex;
    this.upperIndex = upperIndex;
  }

  @Override
  protected Double compute() {
    int range = upperIndex - lowerIndex;
    if (range <= PARALLEL_CUTOFF) {
      return(MathUtils.arraySum(nums, lowerIndex, upperIndex));
    } else {
      int middleIndex = lowerIndex + range/2;
      ParallelArraySummer leftSummer = 
        new ParallelArraySummer(nums, lowerIndex, middleIndex);
      ParallelArraySummer rightSummer = 
        new ParallelArraySummer(nums, middleIndex+1, upperIndex);

      leftSummer.fork();

      Double rightSum = rightSummer.compute();

      Double leftSum = leftSummer.join();

      return(leftSum + rightSum);
    }
  }
}
