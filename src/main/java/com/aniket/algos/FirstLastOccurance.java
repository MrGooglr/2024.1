package com.aniket.algos;

import com.aniket.util.Utility;

public class FirstLastOccurance {
    public static void main(String[] args) {
    int[] arr = new int[]{1,2,5,5,5,5,5,5};

        Utility.printArrayElementAsAString(getFirstAndLastOcc(arr));

    }

    private static int[] getFirstAndLastOcc(int[] sortedArray){
        int length = sortedArray.length, first = 0, last = 1;

        while(first<last && last <= length){
            if(sortedArray[first] != sortedArray[last]){
                first++;
                last++;
            }else{
                last++;
                if(last==length-1 || sortedArray[last] != sortedArray[last+1]) {
                    break;
                }
            }
        }
        return new int[]{first,last};
    }

    private static int[] getFirstAndLastOccUsingBinarySearch(int[] sortedArray){

        return sortedArray;
    }
}
