package readability;

import java.io.*;
import java.util.*;

public class Main {

    private static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(1, "5-6");
        map.put(2, "6-7");
        map.put(3, "7-9");
        map.put(4, "9-10");
        map.put(5, "10-11");
        map.put(6, "11-12");
        map.put(7, "12-13");
        map.put(8, "13-14");
        map.put(9, "14-15");
        map.put(10, "15-16");
        map.put(11, "16-17");
        map.put(12, "17-18");
        map.put(13, "18-24");
        map.put(14, "24+");
    }

    public static void main(String[] args) {

        Console console = new Console(args[0]);
        String text = console.readText();
        ParserText parserText = new ParserText(text);

        int words = parserText.counterWords();
        int sentences = parserText.counterSentences();
        int characters = parserText.counterChar();
        String score = prepareIndexReadability(words, sentences, characters);

        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("The score is: " + score);

        System.out.println("This text should be understood by "
                + result(score) + "-year-olds.");
    }

    private static String prepareIndexReadability(int words, int sentences, int characters) {
        String strScore = String.valueOf(Indexes.indexReadability(words, sentences, characters));
        return strScore.substring(0, strScore.indexOf(".") + 3);
    }

    private static String result(String score) {
        return map.get((int) Math.ceil(Double.parseDouble(score)));
    }
}
