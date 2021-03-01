package readability;

public class ParserText {

    private final String text;

    public ParserText(String text) {
        this.text = text;
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


}
