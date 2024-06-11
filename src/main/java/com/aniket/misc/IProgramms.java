package com.aniket.misc;

import com.aniket.misc.dto.Team;

import java.util.List;

public interface IProgramms {


/**
 * This method is used to print the sublists of a given list.
 * @param list The list from which to generate and print the sublists.
 * @param n The number of elements each sublist should contain.
 */
void printSubList(List<Integer> list, int n);

/**
 * This method is used to find two numbers in an array that add up to a given sum.
 * @param arr The array of integers in which to find the two numbers.
 * @param totalSum The target sum to find in the array.
 */
void twoSum(int[] arr, int totalSum);

/**
 * This method is used to print the Fibonacci sequence up to a given number using recursion.
 * @param tillThisNumber The number up to which the Fibonacci sequence should be printed.
 */
int fibbonaciUsingRecursion(int tillThisNumber);

/**
 * This method is used to print the Fibonacci sequence up to a given number using iteration.
 * @param tillThisNumber The number up to which the Fibonacci sequence should be printed.
 */
void fibbonaciUsingIteration(int tillThisNumber);

List<String> findTop4TeamPlayerNames(List<Team> teamList);

}
