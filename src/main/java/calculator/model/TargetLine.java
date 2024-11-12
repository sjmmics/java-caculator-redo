package calculator.model;

public class TargetLine {

    private final static String BLANK = " ";

    private final static String FORMAT = "^(//[^0-9]\\n){0,1}[1-9][0-9]*$";

    private final String line;

    public TargetLine(String line) {
        validateBasicFormat(line);
        validateCustomDelimiterSpecifier(line);
        this.line = line;
    }

    private void validateCustomDelimiterSpecifier(String line) {
        if (line.startsWith(CustomDelimiter.SPECIFIER_PREFIX)
                && !line.contains(CustomDelimiter.SPECIFIER_SUFFIX)) {
            throw new IllegalArgumentException();
        }

    }

    private void validateBasicFormat(String line) throws IllegalArgumentException {
        if (line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (line.contains(" ")) {
            throw new IllegalArgumentException();
        }

    }
}
