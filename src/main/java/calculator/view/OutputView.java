package calculator.view;

import calculator.model.Result;

public class OutputView {
    public void printResult(Result result) {
        System.out.print(IOMessage.SHOW_RESULT_PREFIX);
        System.out.println(result);
    }
}
