package com.company;

public class Main {

    public static void main(String[] args) {
        MyCustomDoublyLinkedList myCustomDoublyLinkedList = new MyCustomDoublyLinkedList();
        myCustomDoublyLinkedList.add("1");
        myCustomDoublyLinkedList.add("2");
        myCustomDoublyLinkedList.add("3");
        myCustomDoublyLinkedList.addFirst("0");
        myCustomDoublyLinkedList.addLast("4");
        System.out.println(myCustomDoublyLinkedList.offerFirst("-1"));
        System.out.println(myCustomDoublyLinkedList.offerLast("5"));

        System.out.println(myCustomDoublyLinkedList.size());
        System.out.println(myCustomDoublyLinkedList.toString());

        myCustomDoublyLinkedList.remove(3);

        System.out.println(myCustomDoublyLinkedList.toString());


    }
}
