import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {

    public static void print(ArrayList<String> tokensList, ArrayList<String> typeList) {

        int i = 0;
        for (String line : tokensList) {
            System.out.print(line + "\t");
            System.out.println(typeList.get(i));
            i++;
        }
        
    }

    public static ArrayList<String> getTokens(String fileLine) {
        ArrayList<String> tokensList = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        String line = fileLine.trim();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '\"' || currentChar == '“' ) {
                i = processQuotedString(line, tokensList, i);
            } else if (Character.isWhitespace(currentChar)) {
                addToken(tokensList, currentToken.toString());
                currentToken.setLength(0);
            } else if (Tokens.OPERATORS.contains(String.valueOf(currentChar))) {
                i = processOperator(line, tokensList, currentToken, i);
            } else {
                currentToken.append(currentChar);
            }
        }

        addToken(tokensList, currentToken.toString());
        return tokensList;
    }

    private static int processQuotedString(String line, ArrayList<String> tokensList, int startIndex) {
        int endIndex = line.indexOf('\"', startIndex + 1);
        if (endIndex == -1) {
            tokensList.add(line.substring(startIndex));
            return line.length(); // End loop
        }
        tokensList.add(line.substring(startIndex, endIndex + 1));
        return endIndex;
    }

    private static int processOperator(String line, ArrayList<String> tokensList, StringBuilder currentToken, int currentIndex) {
        addToken(tokensList, currentToken.toString());
        currentToken.setLength(0);
        
        String lookahead = "";
        if (currentIndex < line.length() - 1) {
            lookahead = line.substring(currentIndex, currentIndex + 2);
        }

        if (lookahead.equals("--")) {
            tokensList.add(line.substring(currentIndex));
            return line.length(); // End loop
        }

        if (Tokens.OPERATORS.contains(lookahead)) {
            tokensList.add(lookahead);
            return currentIndex + 1;
        }

        tokensList.add(String.valueOf(line.charAt(currentIndex)));
        return currentIndex;
    }

    private static void addToken(ArrayList<String> tokensList, String token) {
        if (!token.isEmpty()) {
            tokensList.add(token);
        }
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
