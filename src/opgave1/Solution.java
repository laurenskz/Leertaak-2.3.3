package opgave1;

import java.util.Arrays;

/**
 * the solution is a sequence of cards placed on the board according to the card positions
 * example without border
 */
public class Solution {

    /**
     * Our board
     */
    private Candidate[][] board = new Candidate[][]{
            new Candidate[]{Candidate.INVALID,Candidate.INVALID,null,Candidate.INVALID},
            new Candidate[]{null,null,null,Candidate.INVALID},
            new Candidate[]{Candidate.INVALID,null,null,null},
            new Candidate[]{Candidate.INVALID,Candidate.INVALID,null,Candidate.INVALID},
    };


    /**
     * Create a new solution
     */
    public Solution() {
    }

    /**
     * Checks whether candidate card of same kind.
     * Checks whether by placing candidate the solution sofar still complies with the rules
     *
     * @param candidate
     * @return boolean indicating whether this candidate can be put in the
     * next free position.
     */
    public boolean fits(Candidate candidate) {
        int[] firstEmptyPlace = firstEmptyPlace();
        String adjacentCards = adjacentCards(firstEmptyPlace[0],firstEmptyPlace[1]);
        return !adjacentCards.contains(""+candidate.getValue());
    }

    /**
     * Records the candidate at the first empty spot of the board
     * @param candidate
     */
    public void record(Candidate candidate) {
        int[] place = firstEmptyPlace();
        board[place[0]][place[1]] = candidate;
    }

    /**
     *
     * @return the first empty spot on the board
     */
    private int[] firstEmptyPlace(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Candidate candidate = board[i][j];
                if (candidate == null && candidate != Candidate.INVALID)return new int[]{i,j};
            }
        }
        return null;
    }

    /**
     *
     * @return true if the board is correct and done
     */
    public boolean complete() {
        int count = 0;
        for (Candidate[] candidates : board) {
            for (Candidate candidate : candidates) {
                if (candidate != null && candidate != Candidate.INVALID) count++;
            }
        }
        return count == 8&&isCorrect();
    }

	}

    /**
     * Shows the solution
     */
    public void show() {
        System.out.println(this);
    }

    /**
     * Erases the last recording from the field and returns it
     * @return
     */
    public Candidate eraseRecording() {
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = board[i].length - 1; j >= 0; j--) {
                if (board[i][j] != null && board[i][j] != Candidate.INVALID) {
                    Candidate toReturn = board[i][j];
                    board[i][j] = null;
                    return toReturn;
                }
            }
        }
        return null;
    }

    // can be used in method isCorrect
    private char mustBeAdjacentTo(char card) {
        if (card == 'A') return 'K';
        if (card == 'K') return 'Q';
        if (card == 'Q') return 'J';
        return '?'; //error
    }

    /**
     * Checks whether the rules below are fulfilled
     * For the positions that can be checked for solution sofar.
     * Rules:
     * Elke aas (ace) grenst (horizontaal of verticaal) aan een heer (king).
     * Elke heer grenst aan een vrouw (queen).
     * Elke vrouw grenst aan een boer (jack).
     *
     * @return true if all checks are isCorrect.
     */
    // uses methods borderCard and mustBeAdjacent to
    private boolean isCorrect() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(!isCorrect(i,j))return false;
            }
        }
        return true;
    }

    /**
     *
     * @param row
     * @param column
     * @return True if this is a correct piece, false if not
     */
    private boolean isCorrect(int row, int column){
        Candidate candidate = board[row][column];
        if(candidate==Candidate.INVALID)return true;//This is not a piece.
        char mustBeAdjacent = mustBeAdjacentTo(candidate.getValue());
        String adjacentCards = adjacentCards(row,column);//Get the adjacent card
        if(mustBeAdjacent=='?')return !adjacentCards.contains(""+candidate.getValue());//If the card does not have to be adjacent we simply return wether it is located next to itself
        return !adjacentCards.contains(""+candidate.getValue())&&adjacentCards.contains(""+mustBeAdjacent);//Standard criterium
    }

    /**
     * Returns all adjacent cards represented as a string of characters.
     * @param row
     * @param column
     * @return
     */
    private String adjacentCards(int row, int column){
        String adjacentCards = "";
        adjacentCards+=cardAt(row-1,column);
        adjacentCards+=cardAt(row+1,column);
        adjacentCards+=cardAt(row,column-1);
        adjacentCards+=cardAt(row,column+1);
        return adjacentCards;
    }

    /**
     * Returns the card at this field.
     * @param row
     * @param column
     * @return
     */
    private String cardAt(int row, int column){
        if(row<0||row>=board.length)return "";
        if(column<0||column>=board[0].length)return "";
        Candidate candidate = board[row][column];
        if(candidate==null||candidate==Candidate.INVALID)return "";
        return ""+candidate.getValue();
    }


    /**
     * @return a representation of the solution on the board
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Candidate[] candidates : board) {
            builder.append(Arrays.toString(candidates));
            builder.append("\n");
        }
        return builder.toString();
    }

}
