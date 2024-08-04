package com.aniket.linkedlist;

public class SSLPractice {

    //Define Head and Tail of a SSL
    Node head = null;
    Node tail =null;

    public void add(int data){
        Node current = new Node(data);
        if(head==null){
            head = current;
            tail=current;
        }else{
            tail.next = current;
            tail=current;
        }
    }

    public void display(SSLPractice practice){
        Node current = practice.head;
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse(SSLPractice practice){
        Node prev = null;
        Node current = practice.head;

        while(current!=null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        practice.head = prev;
    }

    public static void main(String[] args) {
        SSLPractice sslPractice = new SSLPractice();
        sslPractice.add(5);
        sslPractice.add(6);
        sslPractice.add(7);
        sslPractice.add(8);
        sslPractice.add(9);
        sslPractice.display(sslPractice);
        sslPractice.reverse(sslPractice);
        sslPractice.display(sslPractice);
    }

}
