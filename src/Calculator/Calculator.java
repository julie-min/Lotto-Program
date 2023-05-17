package Calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        try {
            System.out.println("숫자를 입력하세요:");
            num1 = scanner.nextDouble();

            System.out.println("진행하고자 하는 연산은? (+, -, *, /):");
            operator = scanner.next().charAt(0);

            System.out.println("숫자를 하나 더 입력하세요:");
            num2 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("입력한 값이 잘못되었습니다. 숫자를 입력해주세요.");
            return;
        }

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }
}
