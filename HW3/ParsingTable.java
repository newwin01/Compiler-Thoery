import java.util.HashMap;
import java.util.Map;

// enum String {
//     PROGRAM, IDENTIFIER, BEGIN, END, IF, ELSE, ELSE_IF, INT, INTEGER, PRINT_LINE, DISPLAY, FOR, WHILE,
//     ASSIGN, COMP_OP, ARITH_OP, NUMBER, STRING
// }

public class ParsingTable {
    

    public static final Map<String, Map<String, String[]>> PARSING_TABLE = new HashMap<>();

    static {
        // Define parsing table based on the grammar
        Map<String, String[]> programRules = new HashMap<>();
        programRules.put("program", new String[]{"program", "IDENTIFIER", "BLOCK"});
        PARSING_TABLE.put("PROGRAM", programRules);

        // Additional rules for other non-terminals
        Map<String, String[]> blockRules = new HashMap<>();
        blockRules.put("begin", new String[]{"begin", "STATEMENT", "end"});
        PARSING_TABLE.put("BLOCK", blockRules);

        Map<String, String[]> statementRules = new HashMap<>();
        statementRules.put("if", new String[]{"IF_BLOCK", "STMT"});
        statementRules.put("int", new String[]{"ASSIGNMENT", "STMT"});
        statementRules.put("integer", new String[]{"ASSIGNMENT", "STMT"});
        statementRules.put("print_line", new String[]{"PRINT", "STMT"});
        statementRules.put("display", new String[]{"DISPLAY", "STMT"});
        statementRules.put("for", new String[]{"FOR_STMT", "STMT"});
        statementRules.put("while", new String[]{"WHILE_STMT", "STMT"});
        statementRules.put("Identifier", new String[]{"ASSIGNMENT", "STMT"});
        PARSING_TABLE.put("STATEMENT", statementRules);

        Map<String, String[]> stmtRules = new HashMap<>();
        stmtRules.put("if", new String[]{"IF_BLOCK", "STMT"});
        stmtRules.put("int", new String[]{"ASSIGNMENT", "STMT"});
        stmtRules.put("integer", new String[]{"ASSIGNMENT", "STMT"});
        stmtRules.put("print_line", new String[]{"PRINT", "STMT"});
        stmtRules.put("display", new String[]{"DISPLAY", "STMT"});
        stmtRules.put("for", new String[]{"FOR_STMT", "STMT"});
        stmtRules.put("while", new String[]{"WHILE_STMT", "STMT"});
        stmtRules.put("Identifier", new String[]{"ASSIGNMENT", "STMT"});
        stmtRules.put("break", new String[]{"break", ";"});
        stmtRules.put("end", new String[]{" "});
        PARSING_TABLE.put("STMT", stmtRules);

        Map<String, String[]> equalSignRule = new HashMap<>();
        equalSignRule.put("=", new String[]{"=" , "ASSIGNED" , "ASSIGN_PRIME"});
        equalSignRule.put(";", new String[]{" "});
        equalSignRule.put(",", new String[]{" "});
        PARSING_TABLE.put("EQUAL", equalSignRule);

        Map<String, String[]> assignRule = new HashMap<>();
        assignRule.put("Identifier", new String[]{"IDENTIFIER", "EQUAL" , "ASSIGN_PRIME"});
        PARSING_TABLE.put("ASSIGN", assignRule);

        Map<String, String[]> assignPrimeRule = new HashMap<>();
        assignPrimeRule.put(",", new String[]{",","IDENTIFIER", "EQUAL", "ASSIGN_PRIME"}); //or eps -> follow set ;
        assignPrimeRule.put(";", new String[]{" "}); //or eps -> follow set ;
        PARSING_TABLE.put("ASSIGN_PRIME", assignPrimeRule);

        Map<String, String[]> assignedRule = new HashMap<>();
        assignedRule.put("Number Literal", new String[]{"NUMORID", "ASSIGNED_PRIME"});
        assignedRule.put("Identifier", new String[]{"NUMORID", "ASSIGNED_PRIME"}); //eps
        PARSING_TABLE.put("ASSIGNED", assignedRule);

        Map<String, String[]> assignedPrimeRule = new HashMap<>();
        assignedPrimeRule.put("+", new String[]{ "ARITH_OP", "NUMORID", "ASSIGNED_PRIME"}); 
        assignedPrimeRule.put("*", new String[]{ "ARITH_OP", "NUMORID", "ASSIGNED_PRIME"}); 
        assignedPrimeRule.put("-", new String[]{ "ARITH_OP", "NUMORID", "ASSIGNED_PRIME"}); 
        assignedPrimeRule.put("/", new String[]{ "ARITH_OP", "NUMORID", "ASSIGNED_PRIME"}); 
        assignedPrimeRule.put(",", new String[]{" "}); //eps
        assignedPrimeRule.put(";", new String[]{" "}); //eps
        PARSING_TABLE.put("ASSIGNED_PRIME", assignedPrimeRule);

        Map<String, String[]> assignmentRules = new HashMap<>();
        assignmentRules.put("int", new String[]{"TYPE", "ASSIGN", ";"});
        assignmentRules.put("integer", new String[]{"TYPE", "ASSIGN", ";"});        
        assignmentRules.put("Identifier", new String[]{"ASSIGN", ";"});  
        PARSING_TABLE.put("ASSIGNMENT", assignmentRules);

        Map<String, String[]> typeRules = new HashMap<>();
        typeRules.put("int", new String[]{"int"});
        typeRules.put("integer", new String[]{"integer"});
        typeRules.put("Identifier", new String[]{" "});
        PARSING_TABLE.put("TYPE", typeRules);

        Map<String, String[]> numOrIDorStringRules = new HashMap<>();
        numOrIDorStringRules.put("Number Literal", new String[]{"NUMBER"});
        numOrIDorStringRules.put("Identifier", new String[]{"IDENTIFIER"});
        numOrIDorStringRules.put("String Literal", new String[]{"STRING"});
        PARSING_TABLE.put("NUMORID", numOrIDorStringRules);

        Map<String, String[]> ForSTMTRules = new HashMap<>();
        ForSTMTRules.put("for", new String[]{"for", "(", "ASSIGNMENT" ,"COMPARISON_STMT", ";", "IDENTIFIER", "INCREMENT", ")" ,"BLOCK"});
        PARSING_TABLE.put("FOR_STMT", ForSTMTRules);

        Map<String, String[]> WhileSTMTRules = new HashMap<>();
        WhileSTMTRules.put("while", new String[]{"while", "(", "COMPARISON_STMT", ")" ,"BLOCK"});
        PARSING_TABLE.put("WHILE_STMT", WhileSTMTRules);

        Map<String, String[]> incrementRule = new HashMap<>();
        incrementRule.put("++", new String[]{"++"});
        PARSING_TABLE.put("INCREMENT", incrementRule);

        Map<String, String[]> compSTMTRules = new HashMap<>();
        compSTMTRules.put("Identifier", new String[]{"NUMORID", "COMOP", "NUMORID"});
        compSTMTRules.put("Number Literal", new String[]{"NUMORID", "COMOP", "NUMORID"});
        PARSING_TABLE.put("COMPARISON_STMT", compSTMTRules);

        Map<String, String[]> comOpRules = new HashMap<>();
        comOpRules.put(">", new String[]{">"});
        comOpRules.put("<", new String[]{"<"});
        comOpRules.put(">=", new String[]{">="});
        comOpRules.put("<=", new String[]{"<="});
        comOpRules.put("==", new String[]{"=="});
        PARSING_TABLE.put("COMOP", comOpRules);

        Map<String, String[]> arithRules = new HashMap<>();
        arithRules.put("+", new String[]{"+"});
        arithRules.put("-", new String[]{"-"});
        arithRules.put("*", new String[]{"*"});
        arithRules.put("/", new String[]{"/"});
        PARSING_TABLE.put("ARITH_OP", arithRules);

        Map<String, String[]> displayRule = new HashMap<>();
        displayRule.put("display", new String[]{"display", "(", "STRING", ")", ";"});
        PARSING_TABLE.put("DISPLAY", displayRule);

        Map<String, String[]> printRule = new HashMap<>();
        printRule.put("print_line", new String[]{"print_line", "(", "NUMORID", ")", ";"}); //ID is possible
        PARSING_TABLE.put("PRINT", printRule);

        Map<String, String[]> ifBlockRule = new HashMap<>();
        ifBlockRule.put("if", new String[]{"IF_STMT", "ELSE_IF_STMT", "ELSE_STMT"});
        PARSING_TABLE.put("IF_BLOCK", ifBlockRule);

        Map<String, String[]> ifStmtRule = new HashMap<>();
        ifStmtRule.put("if", new String[]{"if", "(", "COMPARISON_STMT", ")", "BLOCK"});
        PARSING_TABLE.put("IF_STMT", ifStmtRule);

        Map<String, String[]> ifElseRule = new HashMap<>();
        ifElseRule.put("else_if", new String[]{"else_if", "(", "COMPARISON_STMT", ")", "BLOCK", "NEW_ELSE_IF"});
        ifElseRule.put("else", new String[]{" "});
        ifElseRule.put("end", new String[]{" "});
        ifElseRule.put("Identifier", new String[]{" "});
        ifElseRule.put("break", new String[]{" "});
        ifElseRule.put("int", new String[]{" "});
        ifElseRule.put("integer", new String[]{" "});
        ifElseRule.put("print_line", new String[]{" "});
        ifElseRule.put("display", new String[]{" "});
        ifElseRule.put("for", new String[]{" "});
        ifElseRule.put("while", new String[]{" "});

        //other epsilon requried
        PARSING_TABLE.put("ELSE_IF_STMT", ifElseRule);

        Map<String, String[]> newIfElseRule = new HashMap<>();
        newIfElseRule.put("else_if", new String[]{"else_if", "(", "COMPARISON_STMT", ")", "BLOCK", "NEW_ELSE_IF"});
        newIfElseRule.put("else", new String[]{" "});
        newIfElseRule.put("end", new String[]{" "});
        newIfElseRule.put("Identifier", new String[]{" "});
        newIfElseRule.put("break", new String[]{" "});
        newIfElseRule.put("int", new String[]{" "});
        newIfElseRule.put("integer", new String[]{" "});
        newIfElseRule.put("print_line", new String[]{" "});
        newIfElseRule.put("display", new String[]{" "});
        newIfElseRule.put("for", new String[]{" "});
        newIfElseRule.put("while", new String[]{" "});
         
        PARSING_TABLE.put("NEW_ELSE_IF", newIfElseRule);

        Map<String, String[]> elseRule = new HashMap<>();
        elseRule.put("else", new String[]{"else", "BLOCK"});
        elseRule.put("end", new String[]{" "});
        elseRule.put("Identifier", new String[]{" "});
        elseRule.put("break", new String[]{" "});
        elseRule.put("int", new String[]{" "});
        elseRule.put("integer", new String[]{" "});
        elseRule.put("print_line", new String[]{" "});
        elseRule.put("display", new String[]{" "});
        elseRule.put("for", new String[]{" "});
        elseRule.put("while", new String[]{" "});
         
        PARSING_TABLE.put("ELSE_STMT", elseRule);
    }

    
}
