import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {


    public static void printParsingFaile(String missingToken, int index) {

        System.err.println("Parsing Failed");
        System.out.println(missingToken + " not found " + index);
        System.exit(-1);
        
    }

    public static void printParsingFaile(String missingToken) {

        System.err.println("Parsing Failed");
        System.out.println(missingToken + " not found");
        System.exit(-1);
        
    }


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

        String tokens = "";
        String line = fileLine.trim();
        String lookahead = "";

        for ( int i = 0 ; i < line.length() ; i++) {

            if ( ((Character)line.charAt(i)).equals('\"') ) {

                if ( line.indexOf('\"', i+1) == -1 ) {

                    tokens = line.substring(i);

                    if (tokens.length() != 0)
                        tokensList.add(tokens);
                        
                    tokens = "";
                    break;
                }

                tokens = line.substring(i, line.indexOf('\"', i+1) + 1);
                
                i = line.indexOf('\"', i+1);

                if (tokens.length() != 0)
                    tokensList.add(tokens);

                tokens = "";

                
            } else if ( ((Character)line.charAt(i)).equals(' ')) {

                if (tokens.length() != 0)
                    tokensList.add(tokens);

                tokens = "";

            } else if (  Tokens.OPERATORS.contains( String.valueOf(line.charAt(i)) ) ) {

                if (tokens.length() != 0)
                    tokensList.add(tokens);

                tokens = "";
                lookahead = "";
                
                if (i != line.length() - 1)
                    lookahead = String.valueOf(line.charAt(i)) + String.valueOf(line.charAt(i+1));

                if ( lookahead.equals("--") ) {

                    tokens = line.substring(i);
                    if (tokens.length() != 0)
                        tokensList.add(tokens);
                    
                    tokens = "";
                    break;
                }

                if ( Tokens.OPERATORS.contains(lookahead)) {
                    i = i+1;
                    tokensList.add(lookahead);
                } else {
                    tokensList.add( String.valueOf(line.charAt(i)) );
                }
            
            }  else {
                tokens = tokens + line.charAt(i);
            }

        }

        if (tokens.length() != 0)
            tokensList.add(tokens);

        return tokensList;
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
