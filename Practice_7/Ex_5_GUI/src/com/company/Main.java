package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

class Window extends JFrame {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    private Stack<Integer> reverse(Stack<Integer> stack) {
        Stack<Integer> tmp = new Stack<>();
        int size = stack.size();
        for (int i = 0; i < size; ++i) tmp.push(stack.pop());
        return tmp;
    }

    private boolean compareCard(int c1, int c2) {
        if (c1 == 0 && c2 == 9) return true;
        if (c1 == 9 && c2 == 0) return false;
        return (c1 > c2);
    }

    private void showResult(String text, int steps) {
        if (steps == -1)
            JOptionPane.showMessageDialog(null, text);
        else
            JOptionPane.showMessageDialog(null, text + " " + steps);
    }

    private void play() {
        int steps = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            steps++;
            if (steps > 106) {
                showResult("botva", -1);
                return;
            }

            int c1 = stack1.pop();
            int c2 = stack2.pop();

            if (compareCard(c1, c2)) {
                stack1 = reverse(stack1);
                stack1.push(c1);
                stack1.push(c2);
                stack1 = reverse(stack1);
            } else {
                stack2 = reverse(stack2);
                stack2.push(c1);
                stack2.push(c2);
                stack2 = reverse(stack2);
            }
        }

        if (stack1.isEmpty())
            showResult("second", steps);
        else
            showResult("first", steps);
    }

    private JButton resetBtn   = new JButton("Reset");
    private JButton resultBtn  = new JButton("Result");
    private JButton toLeftBtn  = new JButton("<<");
    private JButton toRightBtn = new JButton(">>");

    private JPanel fieldsPanel  = new JPanel();
    private JPanel chPanel      = new JPanel();
    private JPanel lfBtnPanel   = new JPanel();
    private JPanel mainBtnPanel = new JPanel();
    private JPanel list1Panel   = new JPanel();
    private JPanel list2Panel   = new JPanel();

    private JLabel label1 = new JLabel("First:");
    private JLabel label2 = new JLabel("Second:");
    private JLabel chLabel = new JLabel("Deal cards:");

    private DefaultListModel chModel = new DefaultListModel();
    private DefaultListModel model1  = new DefaultListModel();
    private DefaultListModel model2  = new DefaultListModel();

    private JList chList = new JList();
    private JList list1  = new JList();
    private JList list2  = new JList();

    private void setComponents() {
        chList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for (int i = 0; i < 10; ++i) {
            chModel.addElement(i);
        }
        chList.setModel(chModel);
        chList.setSelectedIndex(0);

        list1.setBackground(new Color(210, 210, 210));
        list2.setBackground(new Color(210, 210, 210));
        chList.setBackground(new Color(200, 200, 200));
        lfBtnPanel.setBackground(new Color(200, 200, 200));

        list1.setFont(new Font("Courier new", Font.BOLD, 16));
        list2.setFont(new Font("Courier new", Font.BOLD, 16));
        chList.setFont(new Font("Courier new", Font.BOLD, 16));

        label1.setFont(new Font("", Font.PLAIN, 14));
        label2.setFont(new Font("", Font.PLAIN, 14));
        chLabel.setFont(new Font("", Font.PLAIN, 14));

        toLeftBtn.setForeground(Color.BLUE);
        toRightBtn.setForeground(Color.BLUE);

        resetBtn.setForeground(Color.RED);
        resultBtn.setEnabled(false);

        label1.setHorizontalAlignment(0);
        label2.setHorizontalAlignment(0);
        chLabel.setHorizontalAlignment(0);

        DefaultListCellRenderer renderer = (DefaultListCellRenderer)chList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        chList.setCellRenderer(renderer);
        list1.setCellRenderer(renderer);
        list2.setCellRenderer(renderer);
    }

    private void addComponents() {
        setLayout(new BorderLayout());

        list1Panel.setLayout(new BorderLayout());
        list1Panel.add(list1, BorderLayout.CENTER);
        list1Panel.add(label1, BorderLayout.NORTH);

        list2Panel.setLayout(new BorderLayout());
        list2Panel.add(list2, BorderLayout.CENTER);
        list2Panel.add(label2, BorderLayout.NORTH);

        mainBtnPanel.setLayout(new GridLayout(1,2));
        mainBtnPanel.add(resetBtn);
        mainBtnPanel.add(resultBtn);

        lfBtnPanel.setLayout(new GridLayout(1,2));
        lfBtnPanel.add(toLeftBtn);
        lfBtnPanel.add(toRightBtn);

        chPanel.setLayout(new BorderLayout());
        chPanel.add(chList, BorderLayout.CENTER);
        chPanel.add(lfBtnPanel, BorderLayout.SOUTH);
        chPanel.add(chLabel, BorderLayout.NORTH);

        fieldsPanel.setLayout(new GridLayout(1,3));
        fieldsPanel.add(list1Panel);
        fieldsPanel.add(chPanel);
        fieldsPanel.add(list2Panel);

        add(mainBtnPanel, BorderLayout.SOUTH);
        add(fieldsPanel, BorderLayout.CENTER);
    }

    private int getSelectedItem() {
        int item = (int)chModel.getElementAt(chList.getSelectedIndex());
        chModel.remove(chList.getSelectedIndex());
        chList.setModel(chModel);
        if (chModel.size() != 0)
            chList.setSelectedIndex(0);
        else {
            toLeftBtn.setEnabled(false);
            toRightBtn.setEnabled(false);
            resultBtn.setEnabled(true);
        }

        return item;
    }

    private void addListeners() {
        toLeftBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item = getSelectedItem();
                model1.addElement(item);
                list1.setModel(model1);
                stack1.push(item);
                if (model1.size() == 5) {
                    toLeftBtn.setEnabled(false);
                    stack1 = reverse(stack1);
                }
            }
        });

        toRightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item = getSelectedItem();
                model2.addElement(item);
                list2.setModel(model2);
                stack2.push(item);
                if (model2.size() == 5) {
                    toRightBtn.setEnabled(false);
                    stack2 = reverse(stack2);
                }
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chModel.clear();
                for (int i = 0; i < 10; ++i) chModel.addElement(i);
                chList.setModel(chModel);
                chList.setSelectedIndex(0);

                model1.clear();
                list1.setModel(model1);

                model2.clear();
                list2.setModel(model2);

                toLeftBtn.setEnabled(true);
                toRightBtn.setEnabled(true);
                resultBtn.setEnabled(false);

                stack1.clear();
                stack2.clear();
            }
        });

        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
                resultBtn.setEnabled(false);
            }
        });
    }

    public Window() {
        super("Card game");

        setComponents();
        addComponents();
        addListeners();

        setSize(400, 320);
        setVisible(true);
    }

}

public class Main {
    public static void main(String[] args) {
        new Window();
    }
}

// botva:
// 3 4 5 6 9
// 0 1 2 7 8