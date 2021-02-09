package readability;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String[] line = sc.nextLine().split("[!?.]");
            int count = 0;
            for (int i = 0; i < line.length; i++) {
                count += line[i].split(" ").length;
            }
            int average = count / line.length;

            if (average > 10 ) {
                System.out.println("HARD");
            } else {
                System.out.println("EASY");
            }
        }
    }
}
