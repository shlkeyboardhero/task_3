package ru.vsu;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //test();
        //test2();
        Frame frameNew= new Frame();
        frameNew.init();
    }

    private static void test2() {
        LinkedList newList = new LinkedList();
        newList.insertLast("(1)");
        newList.insertLast("(2)");
        newList.insertLast("(3)");
        newList.insertLast("(4)");
        newList.insertLast("(5)");
        System.out.println("Текущий список: " + newList);


        Stack newStackList = new Stack();
        while (!newList.isEmpty()) {
            newStackList.push(newList.deleteFirst().dData);
        }

        System.out.println("Текущий стек: " + newStackList);
        while (!newStackList.isEmpty())
            System.out.println("Удаляем: " + newStackList.pop());

        System.out.println("Текущий стек: " + newStackList);
    }

    private static void test() {
        Stack newStack = new Stack();
        newStack.push("3");
        newStack.push("5");
        newStack.push("9");

        System.out.println("Текущий стек: " + newStack);
        System.out.println("Удаляем: " + newStack.pop());
        System.out.println("Удаляем: " + newStack.pop());
        System.out.println("Удаляем: " + newStack.pop());
        System.out.println("Текущий стек: " + newStack);
    }
}
