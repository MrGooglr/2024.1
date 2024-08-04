package com.aniket.misc;

import com.aniket.misc.dto.Employee;
import com.aniket.misc.dto.Team;
import com.aniket.util.Utility;

import java.util.*;
import java.util.stream.Collectors;

public class ProgrammsImpl implements  IProgramms{

    public static void main(String[] args) {
        ProgrammsImpl programms = new ProgrammsImpl();
//        for(int i=0;i<15;i++){
//            System.out.print(programms.fibbonaciUsingRecursion(i) + " ");
//        }
//        System.out.println();
//        programms.fibbonaciUsingIteration(15);
//        System.out.println();
//        programms.twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);
//        programms.printSubList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 4);

//        System.out.println(programms.findTop4TeamPlayerNamesNormal(List.of(new Team(1, "India", List.of("Virat", "Rohit", "Dhawan", "Bumrah")),
//                new Team(2, "Australia", List.of("Smith", "Warner", "Cummins", "Starc")),
//                new Team(3, "England", List.of("Root", "Buttler", "Archer", "Stokes")),
//                new Team(4, "New Zealand", List.of("Williamson", "Boult", "Taylor", "Santner")),
//                new Team(5, "South Africa", List.of("De Kock", "Rabada", "Ngidi", "Du Plessis")),new Team(6, "South Africa2", List.of("De Kock1", "Rabada1", "Ngidi1", "Du Plessis1")))
//        ));

        //printMaxSalEmployeePerDepartment();
        //getEvenfirstAndOddLastArray();
        //System.out.println(getEveryWordReverse("My Name Is"));

        System.out.println(validParenthesis("({{{{}}}))"));
    }


    @Override
    public void printSubList(List<Integer> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            if (i + n <= list.size()) {
                System.out.println(list.subList(i, i + n));
            }
        }
    }

    @Override
    public void twoSum(int[] arr, int totalSum) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == totalSum) {
                System.out.println("The two numbers are: " + arr[left] + " and " + arr[right]);
                return;
            } else if (sum < totalSum) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("No two numbers add up to the given sum.");
    }

    @Override
    public int fibbonaciUsingRecursion(int tillThisNumber) {
        if (tillThisNumber <= 1) {
            return tillThisNumber;
        }
        return fibbonaciUsingRecursion(tillThisNumber - 1) + fibbonaciUsingRecursion(tillThisNumber - 2);
    }

    @Override
    public void fibbonaciUsingIteration(int tillThisNumber) {
        int n1 = 0, n2 = 1;
        System.out.print("Fibonacci Series up to " + tillThisNumber + " numbers: ");
        for (int i = 1; i <= tillThisNumber; ++i) {
            System.out.print(n1 + " ");
            int sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
    }

    @Override
    public List<String> findTop4TeamPlayerNames(List<Team> teamList) {

        return teamList.stream().filter(team -> team.getIccRank()<= 4).collect(Collectors.toList()).stream().map(Team::getPlayerNames).flatMap(List::stream).collect(Collectors.toList());

    }

    public List<String> findTop4TeamPlayerNamesNormal(List<Team> teamList) {
        List<String> listToReturn = new ArrayList<>();
        for(int i=0;i<teamList.size();i++){
            if(teamList.get(i).getIccRank()<=4){
                listToReturn.addAll(teamList.get(i).getPlayerNames());
            }
        }
    return listToReturn;
    }

    public static void printMaxSalEmployeePerDepartment(){
         Employee.getDummyListOfEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)))).entrySet().forEach(stringOptionalEntry -> {
             System.out.println(stringOptionalEntry.getKey());
             System.out.println(stringOptionalEntry.getValue().get().getName());
         });
    }

    public static void getEvenfirstAndOddLastArray() {
        int[] a = new int[]{51, 97, 113, 86, 158, 200};
        int pointerRight = a.length - 1;
        int pointerLeft = 0;
        while (pointerRight > 0 && pointerLeft < pointerRight) {
            if (a[pointerLeft] % 2 != 0 && a[pointerRight] % 2 == 0) {
                int temp = a[pointerLeft];
                a[pointerLeft] = a[pointerRight];
                a[pointerRight] = temp;
                pointerLeft++;
            }
            pointerRight--;
        }
        Utility.printArrayElementAsAString(Arrays.stream(a).boxed().toArray(Integer[]::new));
    }

    public static int[] threeSome(){
        return null;
    }

    public static String getEveryWordReverse(String providedSentence){
        String[] splittedWords = providedSentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<splittedWords.length;i++){
            builder.append(reverse(splittedWords[i]));
        }
        return builder.toString().trim();
    }

    private static StringBuilder reverse(String string){
        return new StringBuilder(new StringBuilder(string).reverse() + " ");
    }

    private static int[] twoSumWithMap(int[] arr, int sum){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement = sum - arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);
        }
        throw new IllegalArgumentException("NO TWO SUM");
    }

    public static boolean validParenthesis(String s){

        if (s.length() == 0 || s.length()%2!=0) {
            return false;
        }
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char ch = st.pop();
                if ((c == ')' && ch != '(') || (c == '}' && ch != '{') || (c == ']' && ch != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();

    }

}
