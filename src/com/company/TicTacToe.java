package com.company;

import java.util.Arrays;

public class TicTacToe {
    private static final int FIELD_SIZE = 3;
    private static final int MAX_MOVES = 9;
    private FieldType [][] board = new FieldType[FIELD_SIZE] [FIELD_SIZE];
    private boolean player1Active;
    private int moveCount = 0;

    public FieldType[][] getBoard() {
        return board;
    }

    public TicTacToe() {
        restart();
    }

    public void restart(){
        player1Active = true;
        moveCount = 0;
        for (FieldType [] row: board ) {
            Arrays.fill(row,FieldType.EMPTY);
        }
    }
    public GameResult placeMark(int rowIndex, int columnIndex){
        if (isIndexOutside(rowIndex) || isIndexOutside(columnIndex)) {
            return GameResult.INCORRECT_INDEX;
        }
        if (board [rowIndex][columnIndex] !=FieldType.EMPTY ){
            return GameResult.INCORRECT_POSITION;
        }
        board [rowIndex][columnIndex] = player1Active ? FieldType.X : FieldType.O;
        player1Active =!player1Active;
        ++moveCount;

        GameResult winner = checkWinner();

        if(winner == GameResult.O_WON || winner == GameResult.X_WON){
            return winner;
        }
        if (moveCount == MAX_MOVES){
            return GameResult.DEUCE;
        }
        return GameResult.CONTINUE;
    }

    public FieldType getValue(int row, int column){
    return board[row][column];
    }

    private GameResult checkWinner() {
        if(checkMark(FieldType.X)) {
            return GameResult.X_WON;
        } else if (checkMark(FieldType.O)) {
            return GameResult.O_WON;
        }

        return GameResult.CONTINUE;
    }

    private boolean checkMark (FieldType mark){
        if (checkRow(mark, 0)) return true;
        if (checkRow(mark, 1)) return true;
        if (checkRow(mark, 2)) return true;
        if (checkColumn(mark, 0)) return true;
        if (checkColumn(mark, 1)) return true;
        if (checkColumn(mark, 2)) return true;

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board [1][1] == mark){
        return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board [1][1] == mark){
            return true;
        }
        return false;
    }

    private boolean checkRow(FieldType mark, int i) {
        if (board[i][0] == board[i][1]
                && board[i][1] == board[i][2]
                && board[i][0] == mark) {
            return true;
        }
        return false;
    }

    private boolean checkColumn(FieldType mark, int i) {
        if (board[0][i] == board[1][i]
                && board[1][i] == board[2][i]
                && board[0][i] == mark) {
            return true;
        }
        return false;
    }

    private static boolean isIndexOutside(int index) {
        if (index <0 || index >FIELD_SIZE-1 ){
            return true;
        }
        return false;

    }
}
