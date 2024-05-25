import java.util.ArrayList;

public class syntrans {

    public static void main(String[] args) {
        
        SmallLexer smallLexer = new SmallLexer();
        smallLexer.runLexer(args);

        interpreter(smallLexer.getTokensList(), smallLexer.getTypesList());
        
    }
    

    public static void interpreter(ArrayList<String> tokenList, ArrayList<String> typeList) {

        boolean print = false;
        boolean multi = false;
        int value = 0;

        for (int i = 0 ; i < tokenList.size() ; i++) {
            String token = tokenList.get(i);

            if (token.equals("print_line")) {
                print = true;
            }

            if (print && token.equals(";")) {
                print = false;
            }

            if (print && typeList.get(i).equals("String Literal") ) {
                token = token.replace("\"","");
                token = token.replace("“","");
                System.out.println(token);
            } 
            if (print && typeList.get(i).equals("Identifier")) {
                System.out.println(SymbolTable.identiferHashMap.get(token).getValue());
            }

            if (Tokens.DECLARE_OPERATORS.contains(token)) {
                while (!token.equals(";")) {
                    token = tokenList.get(++i);
                }
            }

            if (typeList.get(i).equals("Identifier")) { 
                String tempToken = tokenList.get(i);
                token = tokenList.get(++i);

                if (token.equals("=")) {

                    while ( !token.equals("," ) && !token.equals(";")) {
                        
                        if (!multi && typeList.get(i).equals("Identifier")) {
                            value = SymbolTable.identiferHashMap.get(token).getValue();

                        }else if (multi && typeList.get(i).equals("Identifier")) {
                            value = value * SymbolTable.identiferHashMap.get(token).getValue();
                            multi = false;
                        }
                        
                        if (token.equals("*")) {
                            multi = true;
                        }
                        
                        token = tokenList.get(++i);
                    }
                }
                SymbolTable.identiferHashMap.get(tempToken).setValue(value);
            }
            
        }
    }
    
}
