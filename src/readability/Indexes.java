package readability;

public class Indexes {

    public static double indexReadability(int words, int sentences, int characters) {
        return 4.71 * (double) characters / words
                + 0.5 * (double) words / sentences - 21.43;
    }
}
