package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Window extends JFrame {

    private JButton milanBtn      = new JButton("AC Milan");
    private JButton madridBtn     = new JButton("Real Madrid");
    private JLabel scoreLabel     = new JLabel("Result: 0 X 0");
    private JLabel lastScoreLabel = new JLabel("Last Scorer: N/A");
    private JLabel winnerLabel    = new JLabel("Winner: DRAW");
    private JPanel buttonsPanel   = new JPanel();
    private JPanel labelsPanel    = new JPanel();

    private int milanScore  = 0;
    private int madridScore = 0;

    public Window() {
        super("Football");

        setComponents();
        setListeners();
        showComponents();

        setSize(250, 150);
        setVisible(true);
    }

    private void setComponents() {
        winnerLabel.setFont(new Font("", 1, 18));
        winnerLabel.setForeground(Color.BLUE);
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);

        scoreLabel.setFont(new Font("",1,18));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        lastScoreLabel.setForeground(Color.gray);
        lastScoreLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void showComponents() {
        setLayout(new BorderLayout());

        labelsPanel.setLayout(new GridLayout(3,1));
        labelsPanel.add(winnerLabel);
        labelsPanel.add(scoreLabel);
        labelsPanel.add(lastScoreLabel);
        add(labelsPanel, BorderLayout.CENTER);

        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(milanBtn);
        buttonsPanel.add(madridBtn);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void setListeners() {
        milanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                refreshScoreLabel();
                winnerLabel.setText("Winner: " + winner());
                lastScoreLabel.setText("Last Scorer: AC Milan");
            }
        });

        madridBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                refreshScoreLabel();
                winnerLabel.setText("Winner: " + winner());
                lastScoreLabel.setText("Last Scorer: Real Madrid");
            }
        });
    }

    private void refreshScoreLabel() {
        scoreLabel.setText("Result: " + milanScore + " X " + madridScore);
    }

    private String winner() {
        if (milanScore == madridScore)
            return "DRAW";
        else if (milanScore > madridScore)
            return "AC Milan";
        else
            return "Real Madrid";
    }

}

public class Main {

    public static void main(String[] args) {
        new Window();
    }

}
