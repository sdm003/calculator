package calculator.operations;

import java.util.regex.Pattern;

public class Arithmetic {

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public Boolean checkForArabic(String number) {

        if (number == null) {
            return false;
        }
       return pattern.matcher(number).matches();
    }

    public Integer opertaion(Integer number1, Integer number2, String opertaionType) throws Exception {

        Integer result;

        if ("+".equals(opertaionType)) {
            result = number1 + number2;
        } else if ("-".equals(opertaionType)) {
            result = number1 - number2;
        } else if ("*".equals(opertaionType)) {
            result = number1 * number2;
        } else if ("/".equals(opertaionType)) {
            result = number1 / number2;
        } else {
            throw  new Error("Такой операции не существует");
        }

        return result;

    }

}
