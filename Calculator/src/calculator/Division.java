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
public class Division implements Operations {

//    double result;
    @Override
    public void calculation(double numberOne, double numberTwo) {

        double result = numberOne / numberTwo;

        System.out.println("The result is: " + result);

    }

}
