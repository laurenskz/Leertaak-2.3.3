package dynProg.solvers;

import dynProg.Solver;

/**
 * Created by Laurens on 6-3-2016.
 */
public class TopDownSolver implements Solver {

    boolean[][] matrix;
    boolean[][] calculated;
    int[] numbers;

    @Override
    public boolean solve(int[] numbers, int sum) {
        this.numbers=numbers;
        matrix =   new boolean[numbers.length][sum+1];
        calculated = new boolean[numbers.length][sum+1];
        return get(matrix.length-1,sum);
    }

    public boolean calculate(int i, int j){
        if(numbers[i]==j)return true;
        if(get(i-1,j))return true;
        if(get(i-1,j-numbers[i]))return true;
        return false;
    }

    public boolean get(int i, int j){
        if(i<0||i>=matrix.length)return false;
        if(j<0||j>matrix[0].length)return false;
        if(!calculated[i][j]){
            calculated[i][j] = true;
            matrix[i][j] = calculate(i,j);
        }
        return matrix[i][j];
    }

}
