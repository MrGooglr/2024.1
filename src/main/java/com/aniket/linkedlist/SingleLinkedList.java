package com.aniket.linkedlist;

import java.util.LinkedList;

public class SingleLinkedList {
    //making both head and tail of this as null
    Node head = null;
    Node tail = null;
    // add and display elements

    public void addToSLL(int data){
        Node node = new Node(data);
        if(head==null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public void displaySLL(SingleLinkedList list){
        Node current = list.head;

        if(list.head==null){
            System.out.println("List is Empty please add elements by calling addToSLL(int data)");
            return;
        }

        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    public void clearList(SingleLinkedList list){
        Node current = list.head;
        if(list.head==null){
            System.out.println("SSL is already Empty");
            return;
        }else{
            list.head=null;
            list.tail=null;
            System.out.println("SSL got cleared");
        }
    }

    public void printReverseSLL(SingleLinkedList list){
        //No node prev to head
        Node prev = null;
        Node current = list.head;

        while(current!=null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.head = prev;

    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addToSLL(1);
        list.addToSLL(2);
        list.addToSLL(3);
        list.addToSLL(4);
        list.addToSLL(5);
        list.displaySLL(list);
        list.printReverseSLL(list);
        list.displaySLL(list);

    }

}
