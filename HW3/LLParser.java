import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;


public class LLParser {

    Stack<String> stack;


    public static void main(String[] args) {

        SmallLexer smallLexer = new SmallLexer();
        smallLexer.runLexer(args);

        LLParser llParser = new LLParser(smallLexer.getTokensList(), smallLexer.getTypesList());

    }


    public LLParser(ArrayList<String> tokenList, ArrayList<String> typeList ) {

        String matched = "";
        
        stack = new Stack<>();

        //Start
        stack.push("$");
        String[] tempRule;
        String tempToken;
        String buffer;
        int index = 0;

        
        Map<String, String[]> rules;

        
        if (stack.firstElement() == "$") { //program block
                
            rules = ParsingTable.PARSING_TABLE.get("PROGRAM");
            tempRule = rules.get("program");
            stack = Util.pushStack(stack, tempRule);
        }
        

        while ( !stack.lastElement().equals("$") ) {

            tempToken = stack.lastElement();

            if (tempToken == " ") {
                stack.pop();
                continue;
            } 


            Util.printStack(stack); 

            System.out.println("Temp token: " + tempToken); 

            buffer = Util.returnTypeList(tokenList, typeList, index);
            System.out.println("Buffer: " + buffer);
            
            if ( Util.checkNonterminal(tempToken) ) {
                
                if (!Util.match(tempToken, buffer) ) {
                    System.out.println("Parsing failed");
                    System.exit(-1);
                } else { //TODO: Delete
                    matched = matched + " " +  buffer;
                    System.out.println("Good Matched "+ matched);
                }

                index++;
                stack.pop();

            } else {

                stack.pop();

                if ( Util.checkSpecialToken(tempToken, typeList.get(index)) ) {
                    matched = matched + " " +  buffer;
                    System.out.println("Good Matched " + matched);
                    index++;
                    continue;
                } 

                rules = ParsingTable.PARSING_TABLE.get(tempToken);
                tempRule = rules.get(buffer);
                stack = Util.pushStack(stack, tempRule);

            }
            
        }

    }

}
