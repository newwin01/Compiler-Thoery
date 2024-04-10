import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Util {

   

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
