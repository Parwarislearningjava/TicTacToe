package com.company;

import java.util.Scanner;

public class Player {
    public String name;
    public char sign;
    Scanner scanner = new Scanner(System.in);

    public Player(String name, char sign) {
        this.name = name;
        this.sign = sign;
    }

    public int getTurn(){
        System.out.println(name + " -du bist am Zug!");

        int input = scanner.nextInt();
        if (input < 9 && input >= 0) {
            return input;
        }

        System.out.println("Bitte nochmal probieren");
        return getTurn();
    }
}
