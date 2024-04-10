import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Util {

    //Predefined Sets
    public static final ArrayList<Character> ALPHABET_LIST;
    public static final ArrayList<Character> DIGIT_List;
    public static final ArrayList<Character> TOKEN_DELIMITER;

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
   


    public static String readFile(String filePath) {
        StringBuilder fileContents = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContents.append(line);
                fileContents.append(System.lineSeparator());
            }
        } catch (IOException e) {
            return null;
        }
        return fileContents.toString();
    }

}
