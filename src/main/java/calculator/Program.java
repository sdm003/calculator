package calculator;

import calculator.operations.Arithmetic;
import calculator.roman.Roman;

import java.util.Scanner;

public class Program {


    private static Arithmetic arithmetic = new Arithmetic();
    private  static Roman roman = new Roman();

    public static void main(String[] args) {
        boolean isNextOperation = true;

        while(isNextOperation) {

            System.out.println("Введите выражение");

            Scanner scanner = new Scanner(System.in);

            String operation = scanner.next();
            String result = calculator(operation);

            System.out.println(result);
            System.out.println("Еще одна операция? true/false");

            isNextOperation = scanner.nextBoolean();
        }
    }

    public static String calculator(String opertion) {

        opertion = opertion.replaceAll("\\s+","");
        String[] parts = opertion.split("[+-/*]");
        String operators[] = opertion.split("[a-zA-Z0-9]+");
        String result = null;
        int number1;
        int number2;

        try {

            if (!arithmetic.checkForArabic(parts[0]) && !arithmetic.checkForArabic(parts[1])) {

            number1 = roman.valueOf(parts[0]);
            number2 = roman.valueOf(parts[1]);


            result = roman.convertToRoman(arithmetic.opertaion(number1, number2, operators[1]));

        } else if (arithmetic.checkForArabic(parts[0]) && arithmetic.checkForArabic(parts[1])) {

            number1 = Integer.parseInt(parts[0]);
            number2 = Integer.parseInt(parts[1]);

                result = arithmetic.opertaion(number1, number2, operators[1]).toString();


        } else {

            throw new Error("");

        }

    }   catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }

        return result;
    }


}

