package com.company;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {
    @Test
    public void row_and_column_index_1_2_returns_continue(){
        var game = new TicTacToe();
        var result = game.placeMark(1,2);
        Assert.assertSame(result, GameResult.CONTINUE);
    }
    @Test
    public void row_and_column_index_5_2_returns_index_wrong(){
        var game = new TicTacToe();
        var result = game.placeMark(5,2);
        Assert.assertSame(result, GameResult.INCORRECT_INDEX);
    }
    @Test
    public void row_and_column_index_1_negative_5_returns_incorrect_position(){
        var game = new TicTacToe();
        var result = game.placeMark(1,5);
        Assert.assertSame(result, GameResult.INCORRECT_INDEX);
    }

    @Test
    public void position_of_mark_is_incorrect(){
        var game = new TicTacToe();
        game.placeMark(0,0);
        var result = game.placeMark(0,0);
        Assert.assertSame(result, GameResult.INCORRECT_POSITION);
    }
    @Test
    public void position_of_mark_is_correct(){
        var game = new TicTacToe();
        game.placeMark(0,0);
        var result = game.placeMark(1,0);
        Assert.assertSame(result, GameResult.CONTINUE);
    }

    @Test
    public void board_is_filled_deuce(){
        var game = new TicTacToe();
        game.placeMark(0,0);
        game.placeMark(0,1);
        game.placeMark(0,2);
        game.placeMark(1,0);
        game.placeMark(2,0);
        game.placeMark(1,1);
        game.placeMark(1,2);
        game.placeMark(2,2);
        var result = game.placeMark(2,1);
        Assert.assertSame(result, GameResult.DEUCE);
    }
    @Test
    public void x_won_with_first_row(){
        var game = new TicTacToe();
        game.placeMark(0,0);
        game.placeMark(1,0);
        game.placeMark(0,1);
        game.placeMark(1,1);

        var result = game.placeMark(0,2);
        Assert.assertSame(result,GameResult.X_WON);
    }

    @Test
    public void o_won_with_first_column() {
        var game = new TicTacToe();
        game.placeMark(0,1); //X
        game.placeMark(0,0); //O
        game.placeMark(0,2); //X
        game.placeMark(1,0); //O
        game.placeMark(2,2); //X

        var result = game.placeMark(2, 0); //O
        Assert.assertSame(result, GameResult.O_WON);
    }

    @Test
    public void x_won_with_diagonal_1(){
        var game = new TicTacToe();
        game.placeMark(0,0); // X
        game.placeMark(0,1); // O
        game.placeMark(1,1); // X
        game.placeMark(1,0); // O
        var result = game.placeMark(2,2); // X
        Assert.assertSame(result,GameResult.X_WON);
    }
}
