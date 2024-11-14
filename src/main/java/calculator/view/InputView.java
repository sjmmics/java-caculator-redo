package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    
    public String getLine() {
        System.out.println(IOMessage.GUIDE_INPUT);
        return Console.readLine();
    }
    
}
