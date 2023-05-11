import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Store.store(args[0], args[1]);
        } catch (FileNotFoundException e) {
            System.out.println("Wrong file paths.");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
