package com.aniket.misc.dto;

import java.util.Arrays;
import java.util.List;

public class Employee {

    public String name;
    public int age;
    public String department;
    public int salary;


    public Employee(String name, int age, String department, int salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Employee> getDummyListOfEmployees(){
        return Arrays.asList(new Employee("Aniket", 30, "IT1", 10000),
                new Employee("Aniket1", 31, "IT1", 10001),
                new Employee("Aniket2", 32, "IT1", 10002),
                new Employee("Aniket3", 33, "IT3", 10003),
                new Employee("Aniket4", 34, "IT3", 10004),
                new Employee("Aniket5", 35, "IT3", 10005),
                new Employee("Aniket6", 36, "IT4", 10006),
                new Employee("Aniket7", 37, "IT4", 10007));
    }
}
