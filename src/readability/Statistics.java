package readability;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

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

    private ParserText parserText;
    private double average = 0;

    private final int words;
    private final int sentences;
    private final int characters;
    private final long syllables;
    private final long polysyllable;

    public Statistics(ParserText parserText) {
        this.parserText = parserText;
        words = parserText.counterWords();
        sentences = parserText.counterSentences();
        characters = parserText.counterChar();
        syllables = parserText.countSyllables();
        polysyllable = parserText.countPolysyllable();
    }

    public void printStatistic() {
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllable);
    }

    public void printScore(Score score) {
        switch (score) {
            case ARI:
                printARI();
                break;
            case FK:
                printFK();
                break;
            case SMOG:
                printSMOG();
                break;
            case CL:
                printCL();
            case all:
                printARI();
                printFK();
                printSMOG();
                printCL();
                break;
        }
    }

    public double getAverage() {
        return average/4;
    }

    private void printARI() {
        String indexReadability = prepareIndex(Indexes.indexReadability(words, sentences, characters));
        average += Double.parseDouble(result(indexReadability));
        System.out.println("Automated Readability Index: " + indexReadability +
                " (about " + result(indexReadability) + "-year-olds).");
    }
    private void printFK() {
        String fleschKincaidIndex = prepareIndex(Indexes.indexFleschKincaid(words,sentences, syllables));
        average += Double.parseDouble(result(fleschKincaidIndex));
        System.out.println("Flesch–Kincaid readability tests: "
                + fleschKincaidIndex + " (about "
                + result(fleschKincaidIndex)
                + "-year-olds).");
    }
    private void printSMOG() {
        String indexSMOG = prepareIndex(Indexes.indexSMOG(polysyllable, sentences));
        average += Double.parseDouble(result(indexSMOG));
        System.out.println("Simple Measure of Gobbledygook: " + indexSMOG
                + " (about " + result(indexSMOG) + "-year-olds).");
    }
    private void printCL() {
        String indexColemanLiau = prepareIndex(Indexes.indexColemanLiau(words,characters,sentences));
        average += Double.parseDouble(result(indexColemanLiau));
        System.out.println("Coleman–Liau index: " + indexColemanLiau + " (about " + result(indexColemanLiau)
                + "-year-olds).");
    }

    private static String prepareIndex(double index) {
        String strScore = String.valueOf(index);
        return strScore.substring(0, strScore.indexOf(".") + 3);
    }

    private static String result(String score) {
        String[] answer = map.get((int) Math.round(Double.parseDouble(score)))
                .split("-");
        return answer.length == 2 ? answer[1] : answer[0].replaceAll("\\+", "");
    }


}
