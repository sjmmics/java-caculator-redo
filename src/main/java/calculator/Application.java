package calculator;

import calculator.appconfig.AppConfig;
import calculator.controller.CalcController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        CalcController controller = config.getCalcController();
        controller.run();
    }
}
