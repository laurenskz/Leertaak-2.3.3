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
        assertTrue(ttt.chooseMove() == 5);
    }

    @Test
    public void testPositionValue() throws Exception {

    }

    @Test
    public void testAWin() throws Exception {

    }
}