import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner textInput = new Scanner(System.in);

        System.out.println("This is a simple calculator: it can add, subtract, multiply, divide and return the modulo of two numbers.");
        System.out.println("Please type in the operation and the two operands separated by spaces in the form:" +
                            " {operation} {operand} {operand}");
        System.out.println("For example: + 45 89 or * 12 -7");

        String expression = textInput.nextLine();
        display(calculate(expression));
    }

    public static int calculate(String expression){
        String[] parts = expression.split(" ");
        String operation;
        int firstNumber;
        int secondNumber;

        if (parts.length == 3) {
            operation = parts[0];
            firstNumber = Integer.parseInt(parts[1]);
            secondNumber = Integer.parseInt(parts[2]);
        } else {
            return Integer.MIN_VALUE;
        }

        int result = Integer.MIN_VALUE;
        switch (operation){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "%":
                result = firstNumber % secondNumber;
                break;
        }
        return result;
    }

    public static void display(int value){
        if (value == Integer.MIN_VALUE) {
            System.out.println("Something was wrong");
        } else {
            System.out.println("The result is: " + value);
        }
    }
}
