package calculator.service;

import calculator.model.*;

public class CalcService {
    public Result getCalcResult(String line) {
        CustomDelimiter customDelimiter = CustomDelimiter.getFromLine(line);
        Delimiters delimiters = Delimiters.getInitialize();
        delimiters.addCustomDelimiter(customDelimiter);
        LineToCalc lineToCalc = new LineToCalc(line, delimiters);
        NumericSequence sequence =
                NumericSequence.getOfLineWithOutHeadAndDelimiters(lineToCalc.get(), delimiters);
        return sequence.getResult();
    }
    
}
