package dynProg.solvers;

import dynProg.Solver;

import java.util.Arrays;

/**
 * Created by Laurens on 6-3-2016.
 */
public class BottomUpSolver implements Solver {

    boolean[][] matrix;
    @Override
    public boolean solve(int[] numbers, int sum) {
        matrix = new boolean[numbers.length][sum+1];
        for (int i = 0; i < numbers.length; i++) {
            if(i>0){
                matrix[i] = Arrays.copyOf(matrix[i-1],matrix[i].length);
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i-1][j])setTrue(i,j+numbers[i]);
                }
            }
            setTrue(i,numbers[i]);
        }
        return matrix[matrix.length-1][sum];
    }

    private void setTrue(int i, int j){
        if(i>=0&&i<matrix.length){
            if(j>=0&&j<matrix[i].length)matrix[i][j] = true;
        }
    }
}
