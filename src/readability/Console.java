package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Console {

    private String nameFile;

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
}
