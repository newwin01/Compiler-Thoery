import java.util.ArrayList;

public class GrammarVlidator {  
    
    public ArrayList<String> tokenList;
    public ArrayList<String> typeList;

    public GrammarVlidator(ArrayList<String> tokenList, ArrayList<String> typeList) {

        this.tokenList = tokenList;
        this.typeList = typeList;

        int index = 0;
        if ( this.typeList.contains("comment") ) { //remove comments

            for (String type : this.typeList) {

                if (type.equals("comment")) {
                    this.tokenList.remove(index);
                    this.typeList.remove(index);
                }
                index++;

            }
        }

    }

    public boolean programValidator() {

        int index = 0;

        String terminal = tokenList.get(index);

        if ( !terminal.equals("program") ) {
            Util.printParsingFaile("Program");
            return false;
        }

        index++;
        terminal = typeList.get(index);

        if ( !terminal.equals("identifer")) {
            Util.printParsingFaile("Identifier");
            return false;
        } 

        //Validate nonterminal "block"
        if ( blockValidator(index++, tokenList.size()) ) 
            return false;

        return true;
    }


    public boolean blockValidator(int startIndex, int endIndex) {

        String terminal = tokenList.get(startIndex);

        if ( !terminal.equals("begin")) {
            Util.printParsingFaile("begin");
            return false;
        }

        terminal = tokenList.get(endIndex);

        if ( !terminal.equals("end")) {
            Util.printParsingFaile("end");
            return false;
        }

        if ( statementValidator(startIndex+1, endIndex-1) )
            return false;

        return true;
    }        

    public boolean statementValidator(int startIndex, int endIndex) { //need to make statmentprime validator for epsilon

        String terminal = tokenList.get(startIndex);


        if ( Tokens.DECLAR_KEYWORD.contains(terminal)) {   
            declarationValidator(startIndex+1);
        } 

        String type = typeList.get(startIndex);
        if (type.equals("Identifer")) {
            declarationValidator(startIndex);
        }

        if (terminal.equals("if")) {
            //if statement
        }

        if (terminal.equals("print_line")) {
            //print_statement
        }

        return true;

    }

    public boolean declarationValidator(int startIndex) { //starts with 

        int index = startIndex;
        String terminal;

        do{
            terminal = typeList.get(index++);
            if (!terminal.equals("Identifier")){
                Util.printParsingFaile("Identifier");
            }

            terminal = tokenList.get(index++); 

            if (terminal.equals(";")) { //only calling identifier is possible
                break;
            }

            if (!terminal.equals("=")) {
                Util.printParsingFaile("Assignment Operator");
            }
            terminal = typeList.get(index++); //can be identifer or assignment
            if ( ! (terminal.equals("Identifier") || terminal.equals("Number Literal")) ) {
                System.out.println(terminal);
                Util.printParsingFaile("Identifer or Literal");
            }
        } while( tokenList.get(index++).equals(";") );

        return true;
    }

    public boolean ifStatementValidator(int startIndex, int endIndex) {
        return true;
    }

    public boolean printStatmentValidator(int startIndex, int endIndex) {

        int index = startIndex;
        String terminal = tokenList.get(index);

        if (terminal.equals("print_line") ) {
            
        }

        return true;

    }

}


