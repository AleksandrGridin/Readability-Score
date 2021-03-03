package readability;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Console console = new Console(args[0]);
        String text = console.readText();
        ParserText parserText = new ParserText(text);
        Statistics statistics = new Statistics(parserText);

        statistics.printStatistic();

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String score = console.readLine();

        System.out.println();
        statistics.printScore(Score.valueOf(score));

        System.out.println("This text should be understood in average by "
                + statistics.getAverage() + "-year-olds.");
    }




}
