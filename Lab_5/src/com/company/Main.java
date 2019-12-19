package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Animation extends JFrame {

    private BufferedImage pic = ImageIO.read(
            new File("/Users/vladimir/Desktop/Programming/OOP Java/Labs/Lab_5/animation.png"));
    private JLabel picLabel = new JLabel(new ImageIcon(pic));

    public Animation() throws IOException {
        super("Dog");

        setLayout(null);
        setSize(124, 120);
        setResizable(false);
        picLabel.setSize(620,100);
        add(picLabel);
        setVisible(true);

        for (int i = 0; i < 6*10; ++i) {
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException ex) {
                ex.getMessage();
            }
            picLabel.setLocation(-(i*124)%(124*5), 0);
        }
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        new Animation();
    }

}
