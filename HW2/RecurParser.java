
public class RecurParser {

    public static void main(String[] args) {

        SmallLexer smallLexer = new SmallLexer();
        smallLexer.runLexer(args);

        GrammarVlidator grammarVlidator = new GrammarVlidator(smallLexer.getTokensList(), smallLexer.getTypesList());
        
        if (grammarVlidator.programValidator() ) {
           System.out.println("Parsing OK"); 
        }
    }

}
