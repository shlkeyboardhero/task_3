package ru.vsu;

public class Stack {
    private final LinkedList newList = new LinkedList();

    public void push(String c) {
        newList.insertFirst(c);
    }
    public String pop(){
        if (newList.isEmpty())
            return null;
        return newList.deleteFirst().dData;
    }
    public String toString(){
        return newList.toString();
    }
    public boolean isEmpty(){
        return newList.isEmpty();
    }
}
