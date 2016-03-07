package dynProg.solvers;

import dynProg.Solver;

import java.util.Arrays;

/**
 * Created by Laurens on 6-3-2016.
 */
public class RecursiveSolver implements Solver {

    int[] numbers;
    @Override
    public boolean solve(int[] numbers, int sum) {
        this.numbers=numbers;
        return calculate(numbers.length-1,sum);
    }

    public boolean calculate(int i, int j){
        if(i<0||i>=numbers.length)return false;
        if(numbers[i]==j)return true;
        if(calculate(i-1,j))return true;
        if(calculate(i-1,j-numbers[i]))return true;
        return false;
    }
}
