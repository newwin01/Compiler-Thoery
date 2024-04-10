import java.util.ArrayList;

public class SmallLexer{

    DFA identifierDFA;
    DFA commentDFA;
    DFA numberLiteralDFA;
    DFA stringLiteralDFA;


    public static void main(String[] args) {
    
        SmallLexer smallLexer = new SmallLexer();

        smallLexer.predefiningState();

    }   

    public void predefiningState() {


        //Setting Identifier DFA
        int[][] identiferDFATable = {
            {1, 1, -1, -1, -1},
            {1, 1, 1, 1, 1}
        };
        ArrayList<Integer> acceptingStateListIdentifier = new ArrayList<>();
        acceptingStateListIdentifier.add(1);

        identifierDFA = new DFA(identiferDFATable, acceptingStateListIdentifier);
        identifierDFA.setTransition(0, '$');
        identifierDFA.setTransition(1, Tokens.ALPHABET_LIST);
        identifierDFA.setTransition(2, Tokens.DIGIT_List);
        identifierDFA.setTransition(3, '.');
        identifierDFA.setTransition(4, '_');

        System.out.println(identifierDFA.validateToken("345_abc"));

        //Setting Comment
        int[][] commnetDFATable = {
            {1, -1}, 
            {2, -1}, 
            {2, 2}
        };

        ArrayList<Integer> acceptingStateListComment = new ArrayList<>();
        acceptingStateListComment.add(2);

        commentDFA = new DFA(commnetDFATable, acceptingStateListComment);
        commentDFA.setTransition(0, '-');
        commentDFA.setTransition(1, Tokens.ALL_CHARACTERS_LIST);

        System.out.println(commentDFA.validateToken("-- comment first line"));

        //Setting Number Literal
        int[][] numberLiteralDFATable = {
            {1}, 
            {1}
        };

        ArrayList<Integer> acceptingStateListNumberLiteral = new ArrayList<>();
        acceptingStateListNumberLiteral.add(1);

        numberLiteralDFA = new DFA(numberLiteralDFATable, acceptingStateListNumberLiteral);
        numberLiteralDFA.setTransition(0, Tokens.DIGIT_List);

        System.out.println(numberLiteralDFA.validateToken("1234"));
        

        //Setting String Literal

        int[][] stringLiteralDFATable = {
            {1, -1}, 
            {2, 3}, 
            {-1, -1},
            {2, 3}
        };

        ArrayList<Integer> acceptingStateListStringLiteral = new ArrayList<>();
        acceptingStateListStringLiteral.add(2);

        stringLiteralDFA = new DFA(stringLiteralDFATable, acceptingStateListStringLiteral);
        stringLiteralDFA.setTransition(0, '\"');
        stringLiteralDFA.setTransition(1, Tokens.ALL_CHARACTERS_LIST);

        System.out.println(stringLiteralDFA.validateToken("\"1234\""));
    }
    
    

}