import java.util.ArrayList;
import java.util.HashMap;

public class SmallLexer{

    DFA identifierDFA;
    DFA commentDFA;
    DFA numberLiteralDFA;
    DFA stringLiteralDFA;

    ArrayList<String> tokensList = new ArrayList<>();
    ArrayList<String> typesList = new ArrayList<>();


    public static void main(String[] args) {
    
        String fileContents = Util.readFile("testInputs_Scanner/Input3.txt");

        SmallLexer smallLexer = new SmallLexer();
        smallLexer.predefiningState();

        smallLexer.splitIntoToken(fileContents);

    }   

    public void splitIntoToken(String fileContents) {

        String[] fileLine = fileContents.split("\n");
        
        for (String line : fileLine) {

            line = line.trim();

            String tokens = "";
            String types;
            for (int i = 0 ; i < line.length() ; i++) {


                if ( ((Character)line.charAt(i)).equals('\"') ) {

                    tokens = line.substring(i, line.indexOf('\"', i+1) + 1);

                    types = determineState(tokens);

                    i = line.indexOf('\"', i+1);

                    if (types != null) {
                        tokensList.add(tokens);
                        typesList.add(types);
                    }
                    tokens = "";

                }

                else if ( ((Character)line.charAt(i)).equals('-') ) {

                    if ( ( (Character)line.charAt(i+1)).equals('-') ) {

                        tokens = line.substring(i);
                        types = determineState(tokens);
 
                        tokensList.add(tokens);
                        typesList.add(types);

                        tokens = "";
                        break;

                    }                    

                } else if ( ((Character)line.charAt(i)).equals(' ')) {

                    types = determineState(tokens);

                    if (types != null) {
                        tokensList.add(tokens);
                        typesList.add(types);
                    }

                    tokens = "";

                } else if (  Tokens.OPERATORS.contains( String.valueOf(line.charAt(i)) ) ) {

                    types = determineState(tokens);

                    if (types != null) {
                        tokensList.add(tokens);
                        typesList.add(types);
                    }

                    types = SpecialTokens.getSpecialTokens( String.valueOf(line.charAt(i)) );

                    tokensList.add( String.valueOf(line.charAt(i)) );
                    typesList.add(types);

                    tokens = "";

                } else {
                    tokens = tokens + line.charAt(i);
                }

            }

            types = determineState(tokens);

            if (types != null) {
                tokensList.add(tokens);
                typesList.add(types);
            }

        }


        int i = 0;
        for (String line : tokensList) {
            System.out.print(line + "\t");
            System.out.println(typesList.get(i));
            i++;
        }

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

        } else if (  ((Character)token.charAt(0)).equals('$') || Tokens.ALPHABET_LIST.contains( ((Character)token.charAt(0)) )) {

            if (identifierDFA.validateToken(token) ) 

                if (SymbolTable.symbolTableHashMap.containsKey(token))
                    return "Keyword";
                else 
                    return "Identifier";

        }  else if (  ((Character)token.charAt(0)).equals('-')  ) {

            if (commentDFA.validateToken(token)) 
                return "comment";

        }

        return "invalid identifier";
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