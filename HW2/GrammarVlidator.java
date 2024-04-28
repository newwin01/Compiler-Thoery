import java.util.ArrayList;

public class GrammarVlidator {  
    
    public ArrayList<String> tokenList;
    public ArrayList<String> typeList;

    public GrammarVlidator(ArrayList<String> tokenList, ArrayList<String> typeList) {

        this.tokenList = tokenList;
        this.typeList = typeList;

        if ( this.typeList.contains("comment") ) { //remove comments

            for (int i = 0 ; i < tokenList.size() ; i++ ) {

                if (this.typeList.get(i).equals("comment")) {
                    this.tokenList.remove(i);
                    this.typeList.remove(i);
                }
            }
        }

    }

    public boolean programValidator() {

        int index = 0;

        String terminal = tokenList.get(index++);

        if ( !terminal.equals("program") ) {
            Util.printParsingFaile("Program");
            return false;
        }

        terminal = typeList.get(index++);

        if ( !terminal.equals("Identifier")) {
            Util.printParsingFaile("Identifier");
            return false;
        } 

        blockValidator(index);
        return true;
    }


    public int blockValidator(int startIndex) {

        int index = startIndex;

        String terminal = tokenList.get(index++);
        if ( !terminal.equals("begin")) {
            Util.printParsingFaile("begin");
        }

        index = statementValidator(index);

        if ( index == tokenList.size() ) {
            Util.printParsingFaile("end");
        }
        
        terminal = tokenList.get(index);

        if ( !terminal.equals("end") ) {
            Util.printParsingFaile("end");
        }

        return index;
    }        

    public int statementValidator(int startIndex) { 

        String terminal = tokenList.get(startIndex);
        int index = startIndex;

        while( !terminal.equals("end") && index != tokenList.size()) {

            String type = typeList.get(index);
  
            if ( Tokens.DECLAR_KEYWORD.contains(terminal)) {   
                index = declarationValidator(index+1);
            } 

            else if (type.equals("Identifier")) {
                index = declarationValidator(index);
            }
    
            else if (terminal.equals("if")) {
                index = conditionalStatement(index);
            }
    
            else if (terminal.equals("print_line")) {
                index = printStatmentValidator(index);
            } 
            
            else {
                Util.printParsingFaile("end");
            }

            if (index == tokenList.size()) {
                Util.printParsingFaile("end");
            }

            terminal = tokenList.get(index);

        }

        return index;

    }

    public int conditionalStatement(int startIndex) {

        int index;

        index = ifStatementValidator(startIndex);

        if (index == tokenList.size()) {
            Util.printParsingFaile("end");
        }

        String terminal = tokenList.get(index);

        if ( terminal.equals("else_if") ) {
            
            index = elseIfStatementValidator(index);

        }

        if (index == tokenList.size()) {
            Util.printParsingFaile("end");
        }

        terminal = tokenList.get(index);

        if (terminal.equals("else") ) {
            
            index = elseStatementValidation(index);
        }

        return index;
    }

    public int elseStatementValidation(int startIndex) {

        int index = startIndex + 1;

        return blockValidator(index) + 1;

    }

    public int elseIfStatementValidator(int startIndex) {

        int index = startIndex;

        String terminal = tokenList.get(index++);
        
        while ( terminal.equals("else_if") ) {

            if ( !terminal.equals("else_if") ) {
                Util.printParsingFaile("if");
            } 
    
            terminal = tokenList.get(index++);
            if ( !terminal.equals("(") ) {
                Util.printParsingFaile("(");
            }  
    
            terminal = typeList.get(index++); //can be identifer or assignment
            if ( ! (terminal.equals("Identifier") || terminal.equals("Number Literal")) ) {
                Util.printParsingFaile("Identifer or Literal");
            }
    
            terminal = tokenList.get(index++); //can be identifer or assignment
            if ( ! ( Tokens.COMPARISON_OPERATOR.contains(terminal) ) ) {
                Util.printParsingFaile("Comparison Operator");
            }
            
            terminal = typeList.get(index++); //can be identifer or assignment
            if ( ! (terminal.equals("Identifier") || terminal.equals("Number Literal")) ) {
                Util.printParsingFaile("Identifer or Literal");
            }
    
            terminal = tokenList.get(index++);
            if ( !terminal.equals(")") ) {
                Util.printParsingFaile(")");
            } 

        }

        return blockValidator(index) + 1;
    }
    
    public int ifStatementValidator(int startIndex) {

        int index = startIndex;

        String terminal = tokenList.get(index++);
        if ( !terminal.equals("if") ) {
            Util.printParsingFaile("if");
        } 

        terminal = tokenList.get(index++);
        if ( !terminal.equals("(") ) {
            Util.printParsingFaile("(");
        }  

        terminal = typeList.get(index++); //can be identifer or assignment
        if ( ! (terminal.equals("Identifier") || terminal.equals("Number Literal")) ) {
            Util.printParsingFaile("Identifer or Literal");
        }

        terminal = tokenList.get(index++); //can be identifer or assignment
        if ( ! ( Tokens.COMPARISON_OPERATOR.contains(terminal) ) ) {
            Util.printParsingFaile("Comparison Operator");
        }
        
        terminal = typeList.get(index++); //can be identifer or assignment
        if ( ! (terminal.equals("Identifier") || terminal.equals("Number Literal")) ) {
            Util.printParsingFaile("Identifer or Literal");
        }

        terminal = tokenList.get(index++);
        if ( !terminal.equals(")") ) {
            Util.printParsingFaile(")");
        } 

        return blockValidator(index) + 1;
    }


    public int declarationValidator(int startIndex) { //starts with 

        int index = startIndex;
        String terminal;

        do{
            terminal = typeList.get(index++);

            if (!terminal.equals("Identifier")){

                Util.printParsingFaile("Identifier", index);
            }

            terminal = tokenList.get(index++);

            if (terminal.equals(";")) { //only calling identifier is possible
                break;
            }

            if (!terminal.equals("=")) {
                Util.printParsingFaile("Assignment Operator");
            }

            while(true) {
                terminal = typeList.get(index++); //can be identifer or assignment
                if ( ! (terminal.equals("Identifier") || terminal.equals("Number Literal")) ) {
                    Util.printParsingFaile("Identifer or Number Literal");
                }

                if ( Tokens.ARTH_OPERATORS.contains(tokenList.get(index)) ) {
                    index++;
                } else {
                    break;
                }
            }
            
            
        } while( !tokenList.get(index++).equals(";") && index != tokenList.size() );

        return index;
    }

    public int printStatmentValidator(int startIndex) {

        int index = startIndex;
        String terminal = tokenList.get(index++);

        if ( !terminal.equals("print_line") ) {
            Util.printParsingFaile("print_line");
        } 

        terminal = tokenList.get(index++);
        if ( !terminal.equals("(") ) {
            Util.printParsingFaile("(");
        }   

        terminal = typeList.get(index++);
        if ( !terminal.equals("String Literal") ) {
            Util.printParsingFaile("String Literal");
        } 

        terminal = tokenList.get(index++);
        if ( !terminal.equals(")") ) {
            Util.printParsingFaile(")");
        } 

        terminal = tokenList.get(index++);
        if ( !terminal.equals(";") ) {
            Util.printParsingFaile(";");
        } 

        return index;

    }

}


