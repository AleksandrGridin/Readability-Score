package readability;

public class Indexes {

    public static double indexReadability(int words, int sentences, int characters) {
        return 4.71 * (double) characters / words
                + 0.5 * (double) words / sentences - 21.43;
    }

    public static double indexFleschKincaid(int words, int sentences, long syllables) {
        return 0.39 * (double) words/ sentences
                + 11.8 * (double) syllables /words - 15.59;
    }

    public static double indexSMOG(long polysyllable, int sentences) {
        return 1.043 * Math
                .sqrt(polysyllable * (double) 30 / sentences)
                + 3.1291;
    }

    public static double indexColemanLiau(int words, int characters, int sentences) {
        return 0.0588 * ((double) characters / words) * 100
                - 0.296 * ((double) sentences / words) * 100
                - 15.8;
    }
}
