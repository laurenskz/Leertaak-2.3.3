package opgave1;

import java.util.Stack;
/** the solution is a sequence of cards placed on the board according to the card positions
    example without border
*/
public class Solution
{

	private Candidate[][] board = new Candidate[4][4];

	
	public Solution(){
	}

	
	 // Checks whether a candidate with card CardChar is in 
	 // an adjacent position of the board position (row, column)
	 // @param row, column, candidate
	 // @return Boolean indicating if cardChar is found.
	 // can be used in the methods fits and isCorrect
	private boolean bordersCard(int row, int column, char cardChar){
	    //TODO
		return true;
    }
	
	
	/**
	 * Checks whether candidate card of same kind.
	 * Checks whether by placing candidate the solution sofar still complies with the rules
	 * @param candidate
	 * @return boolean indicating whether this candidate can be put in the
	 * next free position.
	 */
	public boolean fits(Candidate candidate){ 
		//TODO
	    return true;
    }

	public void record(Candidate candidate)
	{

	}

	public boolean complete()
	{

	}

	public void show()
	{
		System.out.println(this); 
	}

	public Candidate eraseRecording()
	{
		for (int i = board.length-1; i >= 0; i++) {
			for (int j = board[i].length-1; j >= 0; j++) {
				if()
			}
		}
    }
	
	// can be used in method isCorrect
    private char mustBeAdjacentTo(char card)
    {  
      if (card=='A') return 'K'; 
      if (card=='K') return 'Q'; 
      if (card=='Q') return 'J';
      return '?'; //error
    }
	
	/**
	 * Checks whether the rules below are fulfilled
	 * For the positions that can be checked for solution sofar.
	 * Rules:
	 * Elke aas (ace) grenst (horizontaal of verticaal) aan een heer (king).
	 * Elke heer grenst aan een vrouw (queen).
	 * Elke vrouw grenst aan een boer (jack).
	 * @return true if all checks are correct.
	 */
	// uses methods borderCard and mustBeAdjacent to
	private boolean isCorrect() {
         //TODO
         return true;
     }     
            
	
	/**
	 * @return a representation of the solution on the board
	 */
     public String toString(){
	    //TODO
	    return "";
	}    

}
