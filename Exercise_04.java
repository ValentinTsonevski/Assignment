import java.util.Stack;

public class Exercise_04 {
    public static void main(String[] args) {
        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";

        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(s1));
        System.out.println(calculator.calculate(s2));
        System.out.println(calculator.calculate(s3));

    }

    public static class Calculator {

        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int result = 0;
            int number = 0;
            int sign = 1;

            for (char element : s.toCharArray()) {
                if (Character.isDigit(element)) {
                    number = findNumericValue(number, element);
                } else if (element == '+') {
                    result += sign * number;
                    number = 0;
                    sign = 1;
                } else if (element == '-') {
                    result += sign * number;
                    number = 0;
                    sign = -1;
                } else if (element == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (element == ')') {
                    result += sign * number;
                    number = 0;
                    result *= stack.pop();
                    result += stack.pop();
                }

            }
            result += sign * number;
            return result;
        }

        private int findNumericValue(int number, char element) {
            number = number * 10 + (element - '0');
            return number;
        }

    }

}
