package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Console {

    private final String nameFile;

    public Console(String nameFile) {
        this.nameFile = nameFile;
    }


    public String readText() {

        String text = "";

        try {
            text = Files.lines(Path.of(nameFile))
                    .reduce(String::concat)
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    public String readLine() {
        String line = "";
        try (Scanner scanner = new Scanner(System.in)) {
            line = scanner.nextLine();
        }
        return line;
    }
}
