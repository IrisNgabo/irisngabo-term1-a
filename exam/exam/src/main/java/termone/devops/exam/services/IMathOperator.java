package termone.devops.exam.services;
 import termone.devops.exam.exceptions.InvalidOperationException;
public interface IMathOperator {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
