package com.aniket.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Utility {

    private static final Logger logger = LogManager.getLogger(Utility.class);

    public static void printArrayElementAsAString(Object array){
        if (array instanceof Object[]) {
            logger.info(stream((Object[]) array)
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        } else if (array instanceof int[]) {
            logger.info(stream((int[]) array)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(", ")));
        } else if (array instanceof long[]) {
            logger.info(stream((long[]) array)
                    .mapToObj(Long::toString)
                    .collect(Collectors.joining(", ")));
        } else if (array instanceof double[]) {
            logger.info(stream((double[]) array)
                    .mapToObj(Double::toString)
                    .collect(Collectors.joining(", ")));
        }
    }

    /**
     * given the dimension n it will generate a random int[][] square matrix
     * @param n
     * @return int[][]
     */
    public static int[][] createRandomSquareMatrix(int n) {
        if (n <= 0 || n > 8) {
            throw new IllegalArgumentException("Dimension should be > 0 and <= 8");
        }

        Random random = new Random();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(20) - 5; // Random integers between -50 and 50
            }
        }

        System.out.println("The generated "+n+"X"+n+" matrix is as follows:");
        System.out.println(printAllArrayElementsToString(matrix));
        return matrix;
    }

    public static int[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the matrix (n): ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("The Entered Matrix is as follows : ");
        printAllArrayElementsToString(matrix);
        return matrix;
    }

    public static String printAllArrayElementsToString(int[][] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            sb.append("[");
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]);
                if (j < array[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i < array.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    /**
     * Will create a random Int array of the size as given max size you can give is of 50 with lwer and uppr bounds of the generated nums
     *
     * The content of the array depend on the given bounds
     *
     * @param sizeOfTheArray
     * @param lowerBound
     * @param upperBound
     * @return int[]
     */
    public static int[] createRandomIntArray(int sizeOfTheArray,int lowerBound,int upperBound) {
        if (sizeOfTheArray <= 0 || sizeOfTheArray > 50) {
            throw new IllegalArgumentException("Check size it should be > 0 and < 51");
        }
        int[] array = new int[sizeOfTheArray];
        for (int i = 0; i < sizeOfTheArray; i++) {
            array[i] = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
        }
        System.out.print("Random generated array of size '"+sizeOfTheArray+"' : " + Arrays.toString(array));
        System.out.println();
        return array;
    }
}
