package ru.vsu;

import javax.swing.*;

public class LinkedList {
    private Link head;
    private Link tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void insertFirst(String dd) {
        Link newObj = new Link(dd);
        if (isEmpty())
            tail = newObj;
        else
            newObj.next = head;
        head = newObj;
    }

    public void insertLast(String dd) {
        Link newObj = new Link(dd);
        if (isEmpty())
            head = newObj;
        else
            tail.next = newObj;
        tail = newObj;
    }


    public Link deleteFirst() {
        Link returnHead = head;
        if (!isEmpty())
            head = head.next;
        return returnHead;
    }


    public Link deleteLast() {
        Link returnTail = tail;
        if (!isEmpty()) {
            Link rememberLink = head;
            Link rememberLinkPrevious = null;
            while (rememberLink != tail) {
                rememberLinkPrevious = rememberLink;
                rememberLink = rememberLink.next;
            }
            tail = rememberLinkPrevious;
            if (rememberLinkPrevious != null)
                rememberLinkPrevious.next = null;
            else {
                head = null;
            }
        }
        return returnTail;
    }

    public Link insertAfter(String key, String dd) {
        Link present = head;
        while (!present.dData.equals(key)) {
            present = present.next;
            if (present == null)
                return null;
        }
        Link pasteLink = new Link(dd);
        pasteLink.next = present.next;
        present.next = pasteLink;
        if (present == tail)
            tail = pasteLink;
        return pasteLink;
    }

    public Link deleteKey(String key) {
        Link present = head;
        Link previousPresent = null;
        while (!present.dData.equals(key)) {
            previousPresent = present;
            present = present.next;
            if (present == null)
                return null;
        }
        if (present == head)
            head = present.next;
        else
            previousPresent.next = present.next;
        return present;
    }


    public void displayForward() {
        System.out.print("List (first -->last): ");
        Link present = head;
        while (present != null) {
            present.displayLink();
            present = present.next;
        }
        System.out.println("");
    }


    public String toString() {
        String outputString = new String();
        Link present = head;
        while (present != null) {
            outputString = outputString + present.dData + ",";
            present = present.next;
        }
        return outputString;
    }

}
