package readability;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParserText {

    private final String text;

    public ParserText(String text) {
        this.text = text.replaceAll("The text is:", "");
    }

    public int counterWords() {
        return text.split("\\s").length;
    }

    public int counterChar() {
        return text.replaceAll("\\s","")
                .split("").length;
    }

    public int counterSentences() {
        return text.split("[.!?]").length;
    }

    public long countSyllables() {

        return Arrays.stream(text.split("\\s"))
                .map(CounterSyllables::countSyllables)
                .reduce(Long::sum)
                .get();
    }

    public long countPolysyllable() {
        return Arrays.stream(text.split("\\PL+"))
                .map(CounterSyllables::countSyllables)
                .filter(x -> x > 2)
                .count();
    }
}
