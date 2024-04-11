import java.util.ArrayList;

public class SmallLexer{

    DFA identifierDFA;
    DFA commentDFA;
    DFA numberLiteralDFA;
    DFA stringLiteralDFA;

    ArrayList<String> tokensList = new ArrayList<>();
    ArrayList<String> typesList = new ArrayList<>();


    public static void main(String[] args) {
    
        String fileContents = Util.readFile(args[0]);

        if (fileContents == null) {
            System.err.println("File Not Found Error");
            System.exit(-1);
        }

        SmallLexer smallLexer = new SmallLexer();
        smallLexer.predefiningState();

        smallLexer.splitIntoToken(fileContents);

    }   

    public void splitIntoToken(String fileContents) {

        String[] fileLine = fileContents.split("\n");
        String types;
        
        for (String line : fileLine) {

            ArrayList<String> tokenList = Util.getTokens(line);

            for (String token : tokenList) {

                tokensList.add(token);

                if (Tokens.OPERATORS.contains(token))
                    types = SpecialTokens.getSpecialTokens(token);
                else 
                    types = determineState(token);
                typesList.add(types);

            }
        }
        Util.print(tokensList, typesList);
    }


    public String determineState(String token) {

        if (token.length() == 0 || token.equals(" ")) {
            return null;
        }

        if ( ((Character)token.charAt(0)).equals('\"') ) { 

            if (stringLiteralDFA.validateToken(token))
                return "String Literal";

        } else if ( Tokens.DIGIT_List.contains( ((Character)token.charAt(0)) ) ) {
            
            if (numberLiteralDFA.validateToken(token))
                return "Number Literal";
            else 
                return "Illegal ID starting with digit";

        } else if (  ((Character)token.charAt(0)).equals('$') || Tokens.ALPHABET_LIST.contains( ((Character)token.charAt(0)) )) {

            if (identifierDFA.validateToken(token) ) 

                if ( SymbolTable.keywordHashMap.containsKey(token) )
                    return "Keyword";
                else {
                    SymbolTable.addSymbolTable(token);
                    return "Identifier";
                }

        }  else if (  ((Character)token.charAt(0)).equals('-')  ) {

            if (commentDFA.validateToken(token)) 
                return "comment";

        }

        return "Illegal ID with wrong character";
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

        // System.out.println(identifierDFA.validateToken("345_abc"));

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

        // System.out.println(commentDFA.validateToken("-- comment first line"));

        //Setting Number Literal
        int[][] numberLiteralDFATable = {
            {1}, 
            {1}
        };

        ArrayList<Integer> acceptingStateListNumberLiteral = new ArrayList<>();
        acceptingStateListNumberLiteral.add(1);

        numberLiteralDFA = new DFA(numberLiteralDFATable, acceptingStateListNumberLiteral);
        numberLiteralDFA.setTransition(0, Tokens.DIGIT_List);

        // System.out.println(numberLiteralDFA.validateToken("1234"));s
        

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

        // System.out.println(stringLiteralDFA.validateToken("\"1234\""));
    }
    
    

}