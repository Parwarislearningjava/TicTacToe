package com.company;

public class Main {

    private static final int emptyFieldValue = -1;
    private static final char emptyFieldSign = ' ';

    public static void main(String[] args) {
        int [] board = new int[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = emptyFieldValue;
        }

        Player[] players = { new Player("Spieler 1", '@'), new Player("Spieler 2", '~') };

        // Hier wird der Spieler gespeichert, der gerade am Zug ist
        int turn = 0;
        int winner = -1;

        while (winner == -1) {
            printBoard(players, board);

            int turnField = players[turn].getTurn();

            if (validateTurn(board,turnField)) {
                board[turnField] = turn;

                turn = ++turn % players.length;
            }

            winner = checkWinner(board);
        }

        System.out.println(players[winner].name + " " + "du hast gewonnen!");
    }

    public static boolean validateTurn(int[] board, int field){
        return board[field] == emptyFieldValue;
    }

    public static int checkWinner(int[] board) {
        int winner = emptyFieldValue;

        //TODO prüfen ob alle felder ausgefüllt, wenn ja => spiel beenden, niemand gewinnt
        boolean noWinner = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == emptyFieldValue) {
                noWinner = false;
                break; //brich for loop ab, weil min 1 Feld ist noch beschreibbar
            }
        }

        if(noWinner) {
            return -2; //neuer testwert
        }

        if(board[0] != emptyFieldValue && board [0] == board[1] && board[0] == board[2]) {
            winner = board [0];
        }
        else if(board [3] == board[4] && board[3] == board[5] && board[3] != emptyFieldValue){
            winner = board[3];
        }
        else if(board [6] == board[7] && board[6] == board[8] && board[6] != emptyFieldValue){
            winner = board[6];
        }
        else if(board [0] == board[4] && board[0] == board[8] && board[0] != emptyFieldValue){
            winner = board[0];
        }
        else if(board [2] == board[4] && board[6] == board[2] && board[2] != emptyFieldValue){
            winner = board[2];
        }
        else if(board [0] == board[3] && board[0] == board[6] && board[0] != emptyFieldValue){
            winner = board[0];
        }
        else if(board [1] == board[4] && board[1] == board[7] && board[1] != emptyFieldValue){
            winner = board[1];
        }
        else if(board [2] == board[5] && board[2] == board[8] && board[2] != emptyFieldValue){
            winner = board[2];
        }

        return winner;
    }

    public static char getSymbol(Player[] players, int fieldValue){
        if(fieldValue != emptyFieldValue) {
            return players[fieldValue].sign;
        }

        return emptyFieldSign;
    }

    public static void printBoard(Player[] players, int [] meinBoard){
        System.out.println(" " + getSymbol(players, meinBoard[0]) + " | " + getSymbol(players, meinBoard[1]) + " | " + getSymbol(players, meinBoard[2]));
        System.out.println("---+---+---");
        System.out.println(" " + getSymbol(players, meinBoard[3]) + " | " + getSymbol(players, meinBoard[4]) + " | " + getSymbol(players, meinBoard[5]));
        System.out.println("---+---+---");
        System.out.println(" " + getSymbol(players, meinBoard[6]) + " | " + getSymbol(players, meinBoard[7]) + " | " + getSymbol(players, meinBoard[8]));
    }
}
