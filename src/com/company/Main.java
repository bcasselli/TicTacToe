package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner ply = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Who would you like to play first?");
        String player = ply.nextLine();

        switch (player){

            case "1":
                System.out.println("You have chosen yourself to go first!");
                break;
            case "2":
                System.out.println("You have chosen the computer to go first!");
                break;
            default:
                throw new IllegalArgumentException("You have chosen an invalid player: " + player);
        }
    }
}
