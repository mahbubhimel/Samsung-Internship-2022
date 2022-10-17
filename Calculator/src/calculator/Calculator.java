/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author himel
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double numberOne, numberTwo;
        char operator;
        Scanner sc = new Scanner(System.in);

        numberOne = sc.nextDouble();
        numberTwo = sc.nextDouble();
        operator = sc.next().charAt(0);

        ChooseOperations co = new ChooseOperations(numberOne, numberTwo);
        if (operator == '+') {
            co.operations(new Addition());
        } else if (operator == '-') {
            co.operations(new Subtraction());
        } else if (operator == '*') {
            co.operations(new Multiplication());
        } else if (operator == '/') {
            co.operations(new Division());
        }
    }
}
