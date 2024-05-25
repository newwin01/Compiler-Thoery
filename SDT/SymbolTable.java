import java.util.*;

public class SymbolTable {

    public static HashMap<String, Integer> keywordHashMap = new HashMap<>();
    public static HashMap<String, Attritubte> identiferHashMap = new HashMap<>();
    

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
        keywordHashMap.put("display", 11); 
        keywordHashMap.put("integer", 12); 
        keywordHashMap.put("break", 13); 
    }

    public static void addSymbolTable(String tokens) {

        if (!identiferHashMap.containsKey(tokens))
            identiferHashMap.put(tokens, new Attritubte());

    }

    public static void addAttributeType(String tokens, String type) {

        identiferHashMap.get(tokens).setType(type);

    }

    public static void addAttributeValue(String tokens, int value) {

        identiferHashMap.get(tokens).setValue(value);

    }

    public static void print() {
        for (Map.Entry<String, Attritubte> entry : identiferHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue().getValue());
        }
    }

}
