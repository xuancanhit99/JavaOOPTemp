package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Window extends JFrame {

    String[] colors = {
            "black",
            "red",
            "blue"
    };

    String[] fonts = {
            "Times New Roman",
            "MS Sans Serif",
            "Courier New"
    };

    JComboBox colorCB  = new JComboBox(colors);
    JComboBox fontCB   = new JComboBox(fonts);
    JPanel panel       = new JPanel();
    JTextArea textArea = new JTextArea();

    public Window() {
        super("Lab_6");

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(1,2));
        panel.add(fontCB);
        panel.add(colorCB);
        add(textArea, BorderLayout.CENTER);
        textArea.setFont(new Font("Times New Roman", 0, 20));

        addListeners();

        setSize(400, 400);
        setVisible(true);
    }

    private void addListeners() {
        fontCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                String item = (String)box.getSelectedItem();
                textArea.setFont(new Font(item, 0, 20));
            }
        });

        colorCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                String item = (String)box.getSelectedItem();
                switch (item) {
                    case ("black"):
                        textArea.setForeground(Color.black);
                        break;
                    case ("red"):
                        textArea.setForeground(Color.red);
                        break;
                    case ("blue"):
                        textArea.setForeground(Color.blue);
                        break;
                }
            }
        });
    }

}

public class Main {

    public static void main(String[] args) {
        new Window();
    }
}
