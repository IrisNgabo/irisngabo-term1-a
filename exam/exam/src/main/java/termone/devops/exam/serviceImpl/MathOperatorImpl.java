package termone.devops.exam.serviceImpl;

import termone.devops.exam.exceptions.InvalidOperationException;

public class MathOperatorImpl {
    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }

        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;

            default:
                throw new RuntimeException("Unknown Operation");
        }
    }
}
