/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author himel
 */
public class ChooseOperations {

    double numberOne, numberTwo;

    ChooseOperations(double numberOne, double numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public void operations(Operations operation) {
        operation.calculation(numberOne, numberTwo);
    }
}
