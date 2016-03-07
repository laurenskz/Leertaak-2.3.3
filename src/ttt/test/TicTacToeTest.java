package ttt.test;

import junit.framework.TestSuite;
import org.junit.Test;
import ttt.TicTacToe;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by Jules on 22-2-2016.
 */
public class TicTacToeTest {

    @Test
    public void testChooseMove() throws Exception {
        TicTacToe ttt = new TicTacToe();

        int[][] board = {
                {TicTacToe.COMPUTER,    TicTacToe.HUMAN,    TicTacToe.EMPTY},
                {TicTacToe.EMPTY,       TicTacToe.HUMAN,    TicTacToe.EMPTY},
                {TicTacToe.EMPTY,       TicTacToe.EMPTY,    TicTacToe.EMPTY}
        };

        ttt.setBoard(board);

        assertEquals(7, ttt.chooseMove());
    }

    @Test
    public void testPositionValue() throws Exception {
        TicTacToe ttt = new TicTacToe();

        int[][] board = {
                {TicTacToe.EMPTY,       TicTacToe.HUMAN,    TicTacToe.EMPTY},
                {TicTacToe.EMPTY,       TicTacToe.HUMAN,    TicTacToe.EMPTY},
                {TicTacToe.EMPTY,       TicTacToe.HUMAN,    TicTacToe.EMPTY}
        };

        ttt.setBoard(board);

        assertEquals(TicTacToe.HUMAN_WIN, ttt.positionValue());
    }

    @Test
    public void testAWin() throws Exception {
        TicTacToe ttt = new TicTacToe();

        int[][] board = {
                {TicTacToe.COMPUTER,    TicTacToe.COMPUTER, TicTacToe.COMPUTER},
                {TicTacToe.EMPTY,       TicTacToe.EMPTY,    TicTacToe.EMPTY},
                {TicTacToe.EMPTY,       TicTacToe.EMPTY,    TicTacToe.EMPTY}
        };

        ttt.setBoard(board);

        assertTrue(ttt.isAWin(TicTacToe.COMPUTER));
        assertFalse(ttt.isAWin(TicTacToe.HUMAN));
    }
}