import java.util.*;

public class SymbolTable {

    public static HashMap<String, Integer> symbolTableHashMap = new HashMap<>();

    static {
        symbolTableHashMap = new HashMap<>();
        symbolTableHashMap.put("program", 1);
        symbolTableHashMap.put("int", 2);
        symbolTableHashMap.put("if", 3);
        symbolTableHashMap.put("begin", 4);
        symbolTableHashMap.put("print_line", 5);
        symbolTableHashMap.put("end", 6);
        symbolTableHashMap.put("else_if", 7);
        symbolTableHashMap.put("else", 8);
        symbolTableHashMap.put("while", 9);
    }

}
