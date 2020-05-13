package ru.vsu;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Frame {
    JFrame wndMain =new JFrame("Задача 3. Обратный порядок строк.");
    JFormattedTextField ftfInputValue= new JFormattedTextField();
    JLabel lbInputValue=new JLabel("Введите числа:");
    JLabel lblOutputValue= new JLabel("Итоговый стек:");
    JButton btnAddNumberClass=new JButton("Внести числа в стек (самостоятельная реализация)");
    JButton btnClrAll=new JButton("Очистить все");
    JButton btnAddNumberUtil=new JButton("Внести числа в стек (реализация с библиотекой Java)");
    JButton btnAddNumberRec=new JButton("Внести числа в стек (реализация с рекурсией)");
    JButton btnAddNumberUtilRec= new JButton("Внести числа в стек (реализация с рекурсией и библиотекой Java)");
    JFormattedTextField ftfOutputValue= new JFormattedTextField();
    JPanel pnlButtons= new JPanel(new FlowLayout());

    public void init() {
        wndMain.setBounds(250, 250, 600, 700);
        wndMain.setResizable(false);
        wndMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wndMain.setVisible(true);
        wndMain.setLayout(new GridLayout(5,1));
        wndMain.add(lbInputValue);
        wndMain.add(ftfInputValue);
        pnlButtons.add(btnAddNumberClass);
        pnlButtons.add(btnAddNumberUtil);
        pnlButtons.add(btnAddNumberRec);
        pnlButtons.add(btnAddNumberUtilRec);
        pnlButtons.add(btnClrAll);
        wndMain.add(pnlButtons);
        wndMain.add(lblOutputValue);
        wndMain.add(ftfOutputValue);
        btnAddNumberClass.addActionListener(event-> addNumberClass());
        btnClrAll.addActionListener(event->clrAll());
        btnAddNumberUtil.addActionListener(event->addNumerUtil());
        btnAddNumberRec.addActionListener(event->addNumberRec());
        btnAddNumberUtilRec.addActionListener(event->addNumerUtilRec());
    }

    /*int count=0;
    private void addNumberRec() {
        LinkedList newList = new LinkedList();

        String str = ftfInputValue.getText();
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(",");
        try {
            while (scanner.hasNext()) {
                newList.insertLast(scanner.next());
                count=count+1;
            }
            scanner.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Incorrect line input");
        }
    }*/



    private void addNumberRec() {
        LinkedList newList = new LinkedList();

        String str = ftfInputValue.getText();
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(",");
        try {
            while (scanner.hasNext()) {
                newList.insertLast(scanner.next());
            }
            scanner.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Incorrect line input");
        }
        recursion(newList);
        ftfOutputValue.setText(newList.toString());
    }

    private void recursion(LinkedList lnkd) {
        if (!lnkd.isEmpty()) {
            String temp = "";
            temp = lnkd.deleteLast().dData;
            recursion(lnkd);
            lnkd.insertFirst(temp);
        }
    }

    private void addNumerUtil() {
        java.util.LinkedList<String> newList = new java.util.LinkedList();

        String str = ftfInputValue.getText();
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(",");
        try {
            while (scanner.hasNext()) {
                newList.addLast(scanner.next());
            }
            scanner.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Incorrect line input");
        }

        java.util.Stack newStackList = new java.util.Stack();
        while (!newList.isEmpty()) {
            newStackList.push(newList.removeFirst());
        }

        System.out.println("Текущий стек: " + newStackList);
        String outputStr="";
        while (!newStackList.isEmpty())
            outputStr=outputStr  + newStackList.pop() + ",";
        ftfOutputValue.setText(outputStr);
    }

    private void clrAll() {
        ftfInputValue.setText("");
        ftfOutputValue.setText("");
    }

    private void addNumerUtilRec() {
        java.util.LinkedList<String> newList = new java.util.LinkedList();

        String str = ftfInputValue.getText();
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(",");
        try {
            while (scanner.hasNext()) {
                newList.addLast(scanner.next());
            }
            scanner.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Incorrect line input");
        }
        recursionUtil(newList);
        ftfOutputValue.setText(newList.toString());
    }

    private void recursionUtil(java.util.LinkedList<String> lnkd) {
        if (!lnkd.isEmpty()) {
            String temp = "";
            temp = lnkd.removeLast();
            recursionUtil(lnkd);
            lnkd.addFirst(temp);
        }
    }


    private void addNumberClass() {
        LinkedList newList = new LinkedList();

        String str = ftfInputValue.getText();
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(",");
        try {
            while (scanner.hasNext()) {
                newList.insertLast(scanner.next());
            }
            scanner.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Incorrect line input");
        }

        Stack newStackList = new Stack();
        while (!newList.isEmpty()) {
            newStackList.push(newList.deleteFirst().dData);
        }

        System.out.println("Текущий стек: " + newStackList);
        String outputStr="";
        while (!newStackList.isEmpty())
            outputStr=outputStr  + newStackList.pop() + ",";
        ftfOutputValue.setText(outputStr);
    }
}

