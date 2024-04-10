import java.util.ArrayList;

public class SmallLexer{

    public static void main(String[] args) {
    
        SmallLexer smallLexer = new SmallLexer();

        smallLexer.predefiningState();

    }   

    public void predefiningState() {


        //Setting Identifier DFA

        int[][] identifierTable = {
            {1, 1, -1, -1, -1},
            {1, 1, 1, 1, 1}
        };
        ArrayList<Integer> acceptingStateList = new ArrayList<>();
        acceptingStateList.add(1);
        DFA identifierDFA = new DFA(identifierTable, acceptingStateList);
        identifierDFA.setTransition(0, '$');
        identifierDFA.setTransition(1, Util.ALPHABET_LIST);
        identifierDFA.setTransition(2, Util.DIGIT_List);
        identifierDFA.setTransition(3, '.');
        identifierDFA.setTransition(4, '_');


        

    }
    
    

}