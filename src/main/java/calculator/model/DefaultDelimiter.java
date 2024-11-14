package calculator.model;

import java.util.regex.Pattern;

public record DefaultDelimiter(String letter) implements Delimiter {
    
    @Override
    public String getPatternQuote() {
        return Pattern.quote(letter);
    }
    
    @Override
    public char getChar() {
        return letter.charAt(0);
    }
    
}
