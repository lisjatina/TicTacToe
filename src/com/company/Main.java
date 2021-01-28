package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TicTacToeForm form = new TicTacToeForm();
        form.open();
//	TicTacToe ticTacToe = new TicTacToe();
//	Scanner scanner = new Scanner(System.in);
//
//	while (true) {
//	printBoard(ticTacToe);
//        System.out.println("Enter row and column index: ");
//        int row = scanner.nextInt();
//        int column = scanner.nextInt();
//        var result = ticTacToe.placeMark(row-1, column-1);
//
//        if (result == GameResult.X_WON) {
//            System.out.println("X won!");
//            break;
//        }else if (result == GameResult.O_WON){
//            System.out.println("O won!");
//            break;
//        }else if (result == GameResult.DEUCE){
//            System.out.println("It's deuce!");
//            break;
//        }
//    }
    }
    public static void printBoard (TicTacToe ticTacToe){
        var board = ticTacToe.getBoard();
        System.out.println("---1---2---3--");

        for (int i = 0; i < board.length ; i++) {
            System.out.print(i+1);
            for (int j = 0; j <board[i].length ; j++) {
                String item = "";
                if (board[i][j] == FieldType.EMPTY){
                    item = "|   ";
                }else {
                    item = "| " +board[i][j] + " ";
                }
                System.out.print(item);
            }
            System.out.println("|");
            System.out.println("-----------");
        }
    }
}
