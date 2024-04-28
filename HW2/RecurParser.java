
public class RecurParser {

    public static void main(String[] args) {

        SmallLexer smallLexer = new SmallLexer();
        smallLexer.runLexer(args);

        System.out.println(smallLexer.getTokensUsingIndex(0));

        GrammarVlidator grammarVlidator = new GrammarVlidator(smallLexer.getTokensList(), smallLexer.getTypesList());
        grammarVlidator.declarationValidator(1);
    }

}
