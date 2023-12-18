package termone.devops.exam.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import termone.devops.exam.dtos.DoMathRequestDto;
import termone.devops.exam.exceptions.InvalidOperationException;
import termone.devops.exam.serviceImpls.MathOperatorImpl;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorServiceTest {

    @InjectMocks
    private MathOperatorImpl mathOperatorService;

    @Test
    public void add_operation() throws InvalidOperationException {
        testMathOperation(4,
                9, "+");
    }

    @Test
    public void subtract_operation() throws InvalidOperationException {
        testMathOperation(9, 4, "-");
    }

    @Test
    public void multiply_operation() throws InvalidOperationException {
        testMathOperation(4, 9, "*");
    }

    @Test
    public void divide_operation() throws InvalidOperationException {
        testMathOperation(9, 3, "/");
    }

    private void testMathOperation(double operator1, double operator2, String operation)
            throws InvalidOperationException {
        double calcResponse = performMathOperation(operator1, operator2, operation);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(calcResponse).isEqualTo(actualMathOperator);
    }

    private double performMathOperation(double operator1, double operator2, String operation)
            throws InvalidOperationException {
        switch (operation) {
            case "+":
                return operator1 + operator2;
            case "-":
                return operator1 - operator2;
            case "*":
                return operator1 * operator2;
            case "/":
                if (operator2 == 0) {
                    throw new InvalidOperationException("Cannot divide by zero");
                }
                return operator1 / operator2;
            default:
                throw new InvalidOperationException("Invalid operation: " + operation);
        }
    }
}
