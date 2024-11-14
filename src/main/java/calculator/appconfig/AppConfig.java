package calculator.appconfig;

import calculator.controller.CalcController;
import calculator.service.CalcService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    
    private InputView getInputView() {
        return new InputView();
    }
    
    private OutputView getOutputView() {
        return new OutputView();
    }

    private CalcService getCalcService() {
        return new CalcService();
    }
    
    public CalcController getCalcController() {
        return new CalcController(getCalcService(), getInputView(), getOutputView());
    }
    
}
