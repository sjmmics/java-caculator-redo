package calculator.model;

import java.math.BigInteger;

public class Result {
    
    private final BigInteger result;
    
    public Result(BigInteger result) {
        this.result = result;
    }
    
    @Override
    public String toString() {
        return String.valueOf(result);
    }
    
}
