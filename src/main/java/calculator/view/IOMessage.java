package calculator.view;

public enum IOMessage {
    GUIDE_INPUT("덧셈할 문자열을 입력해주세요."),
    
    SHOW_RESULT_PREFIX("결과 : ");
    
    final String message;
    
    IOMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return message;
    }
}
