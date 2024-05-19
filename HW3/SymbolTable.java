import java.util.*;

public class SymbolTable {

    public static HashMap<String, Integer> keywordHashMap = new HashMap<>();
    public static HashMap<String, Integer> identiferHashMap = new HashMap<>();
    

    static {
        keywordHashMap = new HashMap<>();
        keywordHashMap.put("program", 1);
        keywordHashMap.put("int", 2);
        keywordHashMap.put("if", 3);
        keywordHashMap.put("begin", 4);
        keywordHashMap.put("print_line", 5);
        keywordHashMap.put("end", 6);
        keywordHashMap.put("else_if", 7);
        keywordHashMap.put("else", 8);
        keywordHashMap.put("while", 9);
        keywordHashMap.put("for", 10);
        keywordHashMap.put("display", 11); //newly added
        keywordHashMap.put("integer", 12); //newly added
        keywordHashMap.put("break", 13); //newly added
    }

    public static void addSymbolTable(String tokens) {

        if (!identiferHashMap.containsKey(tokens))
            identiferHashMap.put(tokens, identiferHashMap.size()+1);

    }

    public static void print() {
        for (Map.Entry<String, Integer> entry : identiferHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

}
