package calculator.model;

import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {
    
    public static final String BLANK = " ";
    
    public static final String SPECIFIER_PREFIX = "//";
    
    public static final String SPECIFIER_SUFFIX = "\\n";
    
    public static final int PROPER_FIRST_DELIMITER_INDEX = 2;
    
    public static final int PROPER_LAST_SPECIFIER_SUFFIX_INDEX = 3;
    
    private final String letter;
    
    public CustomDelimiter(String letter) {
        if (letter.length() > 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
        }
        this.letter = letter;
    }
    
    public static CustomDelimiter getFromLine(String line) {
        if (!isProperFormat(line)) {
            throw new IllegalArgumentException();
        }
        if (line.startsWith(SPECIFIER_PREFIX) && IS_PROPER_SUFFIX_INDEX(line)) {
            validateLetter(line);
            String delimiterLetter = getDelimiterLetter(line);
            return new CustomDelimiter(delimiterLetter);
        }
        return new CustomDelimiter("");
    }
    
    private static boolean isProperFormat(String line) {
        if (line.contains(BLANK)) {
            return false;
        }
        if (doesStartWithSpecifierPrefix(line) && IS_PROPER_SUFFIX_INDEX(line)) {
            return true;
        }
        return !doesContainsSpecifierPrefix(line) && !doseContainsSpecifierSuffix(line);
    }
    
    private static boolean doesStartWithSpecifierPrefix(String line) {
        return line.startsWith(CustomDelimiter.SPECIFIER_PREFIX);
    }
    
    private static boolean doesContainsSpecifierPrefix(String line) {
        return line.contains(CustomDelimiter.SPECIFIER_PREFIX);
    }
    
    private static boolean doseContainsSpecifierSuffix(String line) {
        return line.contains(CustomDelimiter.SPECIFIER_SUFFIX);
    }
    
    public static boolean IS_PROPER_SUFFIX_INDEX(String line) {
        return line.lastIndexOf(SPECIFIER_SUFFIX) == PROPER_LAST_SPECIFIER_SUFFIX_INDEX;
    }
    
    private static void validateLetter(String line) throws IllegalArgumentException {
        String letter = line.substring(PROPER_FIRST_DELIMITER_INDEX,
                PROPER_FIRST_DELIMITER_INDEX + 1);
        char letterChar = letter.charAt(0);
        if (Character.isDigit(letterChar)) {
            throw new IllegalArgumentException();
        }
        if (letter.equals(" ")) {
            throw new IllegalArgumentException();
        }
    }
    
    private static String getDelimiterLetter(String line) {
        return line.substring(PROPER_FIRST_DELIMITER_INDEX, PROPER_FIRST_DELIMITER_INDEX + 1);
    }
    
    @Override
    public String letter() {
        return this.letter;
    }
    
    @Override
    public String getPatternQuote() {
        return Pattern.quote(letter);
    }
    
    @Override
    public char getChar() {
        return letter.charAt(0);
    }
    
}
