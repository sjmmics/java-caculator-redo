package calculator.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class NumericSequence {
    private final List<BigInteger> numbers;
    
    public NumericSequence(List<BigInteger> numbers) {
        this.numbers = numbers;
    }
    
    public static NumericSequence getOfLineWithOutHeadAndDelimiters(String line, Delimiters delimiters) {
        if (line.contains(CustomDelimiter.SPECIFIER_PREFIX)
                || line.contains(CustomDelimiter.SPECIFIER_SUFFIX)) {
            throw new IllegalArgumentException("커스텀 구분자 지정 부분이 " +
                    "없는 문자열을 매개변수로 넣으세요.");
        }
        String[] numbers = line.split(delimiters.getSplitRegex());
        List<BigInteger> bigIntegers = Arrays.stream(numbers)
                .filter(number -> !number.isEmpty())
                .map(BigInteger::new)
                .toList();
        return new NumericSequence(bigIntegers);
    }
    
    public Result getResult() {
        BigInteger result = numbers.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
        return new Result(result);
    }
}
