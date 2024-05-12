import java.util.*;

public class Tokens {
     //Predefined Sets
     public static final ArrayList<Character> ALPHABET_LIST;
     public static final ArrayList<Character> DIGIT_List;
     public static final ArrayList<Character> TOKEN_DELIMITER;
     public static final ArrayList<Character> ALL_CHARACTERS_LIST;
 
     static {
         ALL_CHARACTERS_LIST = new ArrayList<>();
         // Adding common symbols
         for (char ch = 32; ch <= 126; ch++) {
             ALL_CHARACTERS_LIST.add(ch);
         }
         Collections.unmodifiableList(ALL_CHARACTERS_LIST); // Make the list unmodifiable
     }
 
     static {
         ALPHABET_LIST = new ArrayList<>();
         for (char ch = 'a'; ch <= 'z'; ch++) {
             ALPHABET_LIST.add(ch);
         }
         for (char ch = 'A'; ch <= 'Z'; ch++) {
             ALPHABET_LIST.add(ch);
         }
         Collections.unmodifiableList(ALPHABET_LIST); 
     }
 
     static {
         DIGIT_List = new ArrayList<>();
         for (char ch = '0'; ch <= '9'; ch++) {
             DIGIT_List.add(ch);
         }
         Collections.unmodifiableList(DIGIT_List); 
     }
 
     static {
         TOKEN_DELIMITER = new ArrayList<>();
         char[] delimiters = {' ', ',', ';' };
         for (char delimiter : delimiters) {
             TOKEN_DELIMITER.add(delimiter);
         }
         Collections.unmodifiableList(DIGIT_List); 
     }
    
     public static final List<String> OPERATORS = 
        Arrays.asList("<", ">", "=", "<=", ">=", "!=", "==", "+", "-", "*", "/", "(", ")", ";", ",", "&&", "||", "&", "|", "!");

    public static final List<String> DECLAR_KEYWORD = 
        Arrays.asList("int", "float", "double");
 
    public static final List<String> COMPARISON_OPERATOR = 
        Arrays.asList("<", ">", "=", "<=", ">=", "!=", "==");

    public static final List<String> ARTH_OPERATORS = 
        Arrays.asList("+", "-", "*", "/");
}
