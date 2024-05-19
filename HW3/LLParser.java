import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;


public class LLparser {

    Stack<String> stack;
    ArrayList<String> tokenList;
    ArrayList<String> typeList;


    public static void main(String[] args) {

        SmallLexer smallLexer = new SmallLexer();
        smallLexer.runLexer(args);

        LLparser llParser = new LLparser(smallLexer.getTokensList(), smallLexer.getTypesList());

        llParser.runLLParser();

        System.out.println("Parsing OK");

    }


    public LLparser(ArrayList<String> tokenList, ArrayList<String> typeList ) {


        this.tokenList = tokenList;
        this.typeList = typeList;
        
        stack = new Stack<>();

        //Start
        stack.push("$");
        String[] tempRule;

        
        Map<String, String[]> rules;

        
        if (stack.firstElement() == "$") { //program block
                
            rules = ParsingTable.PARSING_TABLE.get("PROGRAM");
            tempRule = rules.get("program");
            stack = Util.pushStack(stack, tempRule);
        }

        Util.printStack(stack);
        
    }

    public void runLLParser() {

        String tempToken;
        String buffer;
        int index = 0;

        Map<String, String[]> rules;
        String[] tempRule;


        while ( !stack.lastElement().equals("$") ) {

            tempToken = stack.lastElement();
            
            if (index >= tokenList.size()) {

                buffer = Util.pullOutFirstTerminal(stack);
                System.err.println("Keyword " + buffer + " not matched");
                System.out.println("Parsing failed");
                System.exit(-1);

            }

            buffer = Util.returnTypeList(tokenList, typeList, index);
            
            if ( Util.checkTerminal(tempToken) ) {
                
                if (!Util.match(tempToken, buffer) ) {
                    System.err.println("Keyword spelling error");
                    System.out.println("Parsing failed");
                    System.exit(-1);
                } else { 
                    System.out.println("[MATCHED] " + tempToken +  " - " + tokenList.get(index));
                }

                index++;
                stack.pop();

            } else {

                stack.pop();

                if ( Util.checkSpecialToken(tempToken, typeList.get(index)) ) {

                    if (typeList.get(index) == "Identifier" && !SymbolTable.identiferHashMap.containsKey(tokenList.get(index))) {

                        if (Util.checkKeywordSpelling(tokenList.get(index))) {
                            System.err.println("Keyword Spelling Error");
                        } else {
                            System.err.println(tokenList.get(index) + " Not Declared");
                        }
                        System.out.println("Parsing failed");
                        System.exit(-1);

                    }

                    System.out.println("[MATCHED] " + tempToken +  " - " + tokenList.get(index));
                    index++;
                    continue;
                } 

                rules = ParsingTable.PARSING_TABLE.get(tempToken);
                tempRule = rules.get(buffer);

                if (tempRule[0].equals(" ")) continue;

                stack = Util.pushStack(stack, tempRule);
                // Util.printStack(stack); 

            }
            Util.printStack(stack); 
            
        }

    }

}
