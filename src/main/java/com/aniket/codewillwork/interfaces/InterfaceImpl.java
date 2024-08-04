package com.aniket.codewillwork.interfaces;

import java.util.List;

public class InterfaceImpl implements InterfaceA, InterfaceB{


    public static void main(String[] args) {
        InterfaceImpl interfaceImpl = new InterfaceImpl();
        interfaceImpl.printSubList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 3);
    }

    @Override
    public void printSubList(List<Integer> list, int n) {
        InterfaceA.super.printSubList(list, n);
    }
}
