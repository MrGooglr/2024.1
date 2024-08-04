package com.aniket.codewillwork.interfaces;

import java.util.List;

public interface InterfaceA {

    default void printSubList(List<Integer> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            if (i + n <= list.size()) {
                System.out.println(list.subList(i, i + n));
            }
        }
    }

}
