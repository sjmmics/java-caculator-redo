package calculator.model;

import static calculator.model.CustomDelimiter.IS_PROPER_SUFFIX_INDEX;

public class LineToCalc {
   
    private final String line;
    
    public LineToCalc(String line, Delimiters delimiters) {
        String lineWithOutHead = getLineWithOutHead(line);
        for (int i = 0; i < lineWithOutHead.length(); i++) {
            char letter = lineWithOutHead.charAt(i);
            if (!delimiters.isProperLetter(letter)) {
                throw new IllegalArgumentException();
            }
        }
        this.line = lineWithOutHead;
    }
    
    private String getLineWithOutHead(String line) {
        if (line.startsWith(CustomDelimiter.SPECIFIER_PREFIX) && IS_PROPER_SUFFIX_INDEX(line)) {
            return line.substring(CustomDelimiter.PROPER_LAST_SPECIFIER_SUFFIX_INDEX +
                    CustomDelimiter.SPECIFIER_SUFFIX.length());
        }
        return line;
    }
    
    public String get() {
        return this.line;
    }
    
}
