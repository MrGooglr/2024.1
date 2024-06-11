package com.aniket.algos;

public class SearchingUnSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1,5,6,8};
        System.out.println(searchInUnSortedArray(arr,arr.length,13));
    }


    private static String searchInUnSortedArray(int[] arr, int size, int numToFind){
        if(arr[size-1] == numToFind){
            return "FOUND";
        }

        int lastNumAsBackup = arr[size-1];
        arr[size-1] = numToFind; // stopper

        for(int i=0;;i++){ // no stopping condition here as stopper is the num at last itself

            if(arr[i] == numToFind){
                arr[size-1] = lastNumAsBackup; // again making the array as before

                if(i < size-1){
                    return "FOUND";
                }else{
                    return "NOT FOUND";
                }
            }
        }

    }

}
