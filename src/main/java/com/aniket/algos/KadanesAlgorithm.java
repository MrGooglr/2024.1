package com.aniket.algos;



import com.aniket.util.Utility;

/**
 * This algo is uesd to find maximum sum from a subarray where we can return the max sum from a contiguous subarray not the subarray itself
 */
public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] arr = Utility.createRandomIntArray(5,-10,10);
        System.out.println("Max sum from contiguous subArray we can have is [using Kadanes Algo]: "+getMaxSumSubArray(arr,arr.length));
    }
    //[7, -4, 2, -3, 10]
    private static int getMaxSumSubArray(int[] givenArray,int arraySize){
        int maxSum = Integer.MIN_VALUE;//assuming -infinity
        int currentSum = 0;//assuming

        for(int i=0;i<arraySize;i++){
            currentSum = givenArray[i]+currentSum;
            if(currentSum<0){
                currentSum=0;
            }
            maxSum = Math.max(currentSum,maxSum);
        }

        return maxSum;
    }
}
