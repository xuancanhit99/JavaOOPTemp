package com.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Choose the variant: ");
        int choice = in.nextInt();
        in = new Scanner(System.in);

        switch (choice){
            case 1:
            case 3:
                try {
                    FileWriter writer = new FileWriter("text.txt", false);
                    System.out.print("Enter a text: ");
                    writer.write(in.nextLine() + "\n");
                    writer.flush();
                    System.out.println("--- Text is successfully written ---");
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:
                try {
                    FileReader reader = new FileReader("text.txt");
                    Scanner fileIn = new Scanner(reader);
                    while(fileIn.hasNextLine()){
                        System.out.println(fileIn.nextLine());
                    }
                } catch (IOException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case 4:
                try {
                    FileWriter writer = new FileWriter("text.txt", true);
                    System.out.print("Enter a text: ");
                    writer.write(in.nextLine() + "\n");
                    writer.flush();
                    System.out.println("--- Text is successfully written ---");
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            default:
                System.out.println("ERROR!");
                break;
        }
    }
}
