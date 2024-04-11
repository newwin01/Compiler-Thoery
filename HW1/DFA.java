import java.util.ArrayList;

public class DFA {
    
    int[][] transitionTable;
    ArrayList<Object> transitionRow;
    ArrayList<Integer> acceptingStateList;
     
    /**
     * 
     * @param transitionTable
     * @param acceptingStateList
     * 
     * Put tranisition table and accepting state lists
     */
    
    public DFA(int[][] transitionTable, ArrayList<Integer> acceptingStateList) {
        this.transitionTable = transitionTable;
        this.acceptingStateList = acceptingStateList;
        transitionRow = new ArrayList<>();
    }

    public void setTransition(int row, Object setOfTokens) {
        transitionRow.add(row, setOfTokens);
    }

    private int doTransition(int state, int inputChar) {

        int result;

        result = transitionTable[state][inputChar];
     
        return result;
    }

    @SuppressWarnings("unchecked")
    private int findInputChar(Character inputChar) {

        for (int i = 0 ; i < transitionRow.size() ; i++) {

            Object tempTransitionRow = transitionRow.get(i);

            if ( tempTransitionRow instanceof Character) {
                Character tranisitionChar = (Character)tempTransitionRow;

                if (tranisitionChar.equals(inputChar)) return i;

            } else if ( tempTransitionRow instanceof ArrayList<?>) {  

                ArrayList<Character> tranisitionChar = (ArrayList<Character>)tempTransitionRow;

                if (tranisitionChar.contains(inputChar)) return i;

            } else {

                System.err.println("Not supported");
                return -1;

            }
        }

        return -1;
    }

    public boolean validateToken(String token) {

        int state = 0;
        int inputChar;

        for (int i = 0 ; i < token.length() ; i++) {

            inputChar = findInputChar( (Character) token.charAt(i));

            if (inputChar == -1) return false; //Not in the state, invalid token

            state = doTransition(state, inputChar);

            if (state == -1) return false; //going to error state, invalid token
        }

        if (acceptingStateList.contains(state))
            return true;
        else
            return false;
    }

}
