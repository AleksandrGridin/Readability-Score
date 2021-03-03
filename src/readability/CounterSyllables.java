package readability;

import java.util.regex.Pattern;

import static java.lang.Math.max;

public class CounterSyllables {

    private static Pattern PATTERN_SYLLABLE = Pattern.compile("([aiouy]|e(?!$))+");

    static long countSyllables(final String word) {
        return max(1, PATTERN_SYLLABLE.matcher(word).results().count());
    }

}