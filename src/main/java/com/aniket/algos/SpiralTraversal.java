package com.aniket.algos;

import com.aniket.util.Utility;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //printSpiralWay(matrix);
        printSpiral(matrix);
    }

    public static void printSpiralWay(int[][] matrix){

        int left = 0; int right = matrix[0].length-1; //columns
        int top = 0; int bottom = matrix.length-1; // rows

        while (left<=right && top <= bottom){
            //traverse all from left to right
            for(int i=left;i<=right;i++){
                System.out.print(" "+matrix[top][i]);
            }
            top++;

            //traverse all from top to bottom from right
            for(int i=top;i<=bottom;i++){
                System.out.print(" "+matrix[i][right]);
            }
            right--;

            //traverse all from bottom from right to left
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    System.out.print(" "+matrix[bottom][i]);
                }
                bottom--;
            }

            //traverse from bottom to top from left
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    System.out.print(" "+matrix[i][left]);
                }
                left++;
            }
        }
    }

    public static void printSpiral(int[][] matrix){

        int left = 0, right=matrix[0].length-1; // column length
        int top = 0, bottom=matrix.length-1; //row length

        while(left<=right && top<=bottom){
            //traverse top row from left to right
            for(int i=left;i<=right;i++){
                System.out.print(" "+matrix[top][i]);
            }
            top++;

            //traverse right column from top to bottom
            for(int i=top;i<=bottom;i++){
                System.out.print(" "+matrix[i][right]);
            }
            right--;

            if(left<=right){
                //traverse from right to left bottom row
                for(int i=right;i>=left;i--){
                    System.out.print(" "+matrix[bottom][i]);
                }
                bottom--;
            }

            if(top<=bottom){
                //traverse from bottom to top from left column
                for(int i=bottom;i>=top;i--){
                    System.out.print(" "+matrix[i][left]);
                }
                left++;
            }

        }
    }
}
