package com.aniket.algos;

import com.aniket.util.Utility;

import java.util.Arrays;

/**
 * Minimise the maximum difference between heights [V.IMP]
 *
 * The idea is to increase the first i towers by k and decrease the rest tower by k after sorting the heights, then calculate the maximum height difference.
 * This can be achieved using sorting.
 *
 */
public class MinMaxHeight {

    public static void main(String[] args) {
        int[] arr = { 7, 4, 8, 8, 8, 9 };
        System.out.println(getMinDiff(arr,arr.length,6));
    }

    private static int getMinDiff(int[] arr, int size, int operationNum){
        //We can operate on Sorted array
        Arrays.sort(arr);

        int tempMin = arr[0];
        int tempMax = arr[size-1];
        int maxPossibleDiff = arr[size-1] - arr[0];

        for (int i = 1; i < size; i++) {
            // if on subtracting operationNum we got negative then
            // continue
            if(arr[i] - operationNum < 0){
                continue;
            }

            // Minimum element when we add k to whole array
            tempMin = Math.min(arr[0] + operationNum , arr[i] - operationNum);
            // Maximum element when we subtract k from whole array
            tempMax = Math.max(arr[i -1]+operationNum,arr[size-1]-operationNum);
        }
        return Math.min(maxPossibleDiff,tempMax - tempMin);
    }

}
