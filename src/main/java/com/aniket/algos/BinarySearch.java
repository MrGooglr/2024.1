package com.aniket.algos;

import java.util.Arrays;
import java.util.Objects;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,2,7,2};
        Arrays.sort(arr);
        int indexSearch = binarySearch(arr,5,0);
        System.out.println("Found at "+indexSearch);
    }

    private static int binarySearch(int[] arr,int num,int offset){
        int mid = arr.length/2;
        int current = arr[mid];
        if(num == current){
            return offset+mid;
        }else if(num > current){
            return binarySearch(Arrays.copyOfRange(arr,mid,arr.length),num,offset+mid);

        }else{
            return binarySearch(Arrays.copyOfRange(arr,0,mid),num,offset);
        }
    }

}
