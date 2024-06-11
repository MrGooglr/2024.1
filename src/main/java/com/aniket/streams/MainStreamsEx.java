package com.aniket.streams;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreamsEx {

    public static void main(String[] args) {
        //printNthHigestSal(2, getTheGeneratedData(5));
        //getOddEvenFromList();
    }


    /**
     * This method joins elements of a list with a prefix and suffix.
     * It uses Java streams and the joining collector to concatenate the elements of the list into a string.
     * The joining collector is provided with a delimiter, a prefix, and a suffix.
     * The delimiter is a comma followed by a space, which is used to separate the elements in the resulting string.
     * The prefix is an opening square bracket, and the suffix is a closing square bracket.
     * The resulting string is then printed to the console.
     */
    private static void joinElementsWithSuffixPrefix() {
        List<String> list = List.of("A", "B", "C", "D", "E");
        String result = list.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }


    /**
     * This method separates a list of integers into odd and even numbers.
     * It uses Java streams and the partitioningBy collector to categorize the numbers.
     * The result is a map where the key is a boolean indicating whether the numbers are even (true) or odd (false),
     * and the value is a list of numbers that fall into that category.
     * The method then prints this map.
     */
    private static void getOddEvenFromList() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0)).entrySet().forEach(System.out::println);
    }

    /**
     * This method prints the names of the employees who have the nth highest salary.
     *
     * @param nthHighestSal The rank of the salary to be considered. For example, if nthHighestSal is 2,
     *                      the method will print the names of the employees who have the second highest salary.
     * @param dataSource    The data source from which the employee names and their salaries are to be fetched.
     *                      The data source is a Map where the keys are the employee names and the values are their salaries.
     */
    private static void printNthHigestSal(int nthHighestSal, Map<String, Integer> dataSource) {

        // Group the data source by salary, mapping each salary to a list of employee names who have that salary.
        // Then, sort the grouped data in reverse order of salary (i.e., highest salary first).
        // Skip the first nthHighestSal-1 salaries to get to the nth highest salary.
        // Get the list of employee names who have the nth highest salary.
        List<String> test = dataSource.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .skip(nthHighestSal - 1)
                .findAny()
                .get()
                .getValue();

        // Print the names of the employees who have the nth highest salary.
        System.out.println(test);
    }

    private static Map<String, Integer> getTheGeneratedData(int amountOfDataRows) {

        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i <= amountOfDataRows; i++) {
            map.put("Aniket" + i, i * 1000);
        }
        return map;
    }

}
