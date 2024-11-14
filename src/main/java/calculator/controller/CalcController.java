package calculator.controller;

import calculator.model.Result;
import calculator.service.CalcService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalcController {
    
    private final CalcService service;
    
    private final InputView inputView;
    
    private final OutputView outputView;
    
    public CalcController(CalcService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }
    
    public void run() {
        String line = inputView.getLine();
        Result result = service.getCalcResult(line);
        outputView.printResult(result);
    }
}
