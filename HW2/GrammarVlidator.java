import java.util.ArrayList;

public class GrammarVlidator {  
    
    public ArrayList<String> tokenList;
    public ArrayList<String> typeList;

    public GrammarVlidator(ArrayList<String> tokenList, ArrayList<String> typeList) {
        this.tokenList = tokenList;
        this.typeList = typeList;
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
        

        if (statementValidator(startIndex+1, endIndex-1))
            return false;

        return true;
    }        

    public boolean statementValidator(int startIndex, int endIndex) {

        return true;

    }

}


