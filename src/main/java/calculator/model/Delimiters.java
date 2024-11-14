package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Delimiters {
    
    private final List<Delimiter> delimiters;
    
    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }
    
    public static Delimiters getInitialize() {
        List<Delimiter> delimiters = new ArrayList<>();
        Delimiter comma = new DefaultDelimiter(",");
        Delimiter semiColon = new DefaultDelimiter(":");
        delimiters.add(comma);
        delimiters.add(semiColon);
        return new Delimiters(delimiters);
    }
    
    public void addCustomDelimiter(CustomDelimiter customDelimiter) {
        String letter = customDelimiter.letter();
        if (!letter.isEmpty()) {
            delimiters.add(customDelimiter);
        }
    }
    
    public String getSplitRegex() {
        return delimiters.stream()
                .map(Delimiter::getPatternQuote)
                .collect(Collectors.joining(")|(", "(", ")"));
    }
    
    public boolean isProperLetter(char letter) {
        if (Character.isDigit(letter)) {
            return true;
        }
        return containsCharacter(letter);
    }
    
    private boolean containsCharacter(char letter) {
        for (Delimiter delimiter : delimiters) {
            if (letter == delimiter.getChar()) {
                return true;
            }
        }
        return false;
    }

}
