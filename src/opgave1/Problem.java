package opgave1;


import java.util.ArrayList;

public class Problem
{
    private ArrayList<Candidate> candidates = new ArrayList<>();

    private Solution solution = new Solution();
    public void solve()
    {
        int index=0;
        while (index<candidates.size())
        {
            if (solution.fits(candidates.get(index)))
            {
                //move candidate from candidates to so
                solution.record(candidates.remove(index));
                if (solution.complete())
                {
                    solution.show();
                }
                else
                {
                    solve();
                }
                //move candidate form solution to cand
                candidates.add(index,solution.eraseRecording());
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        for (int i = 0; i < 2; i++) {
            problem.candidates.add(new Candidate('A'));
            problem.candidates.add(new Candidate('K'));
            problem.candidates.add(new Candidate('Q'));
            problem.candidates.add(new Candidate('J'));
        }
        problem.solve();
    }
}
