package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    private static final String NUMBER_REG = "^[0-9]*$";
    private static final String OPERATION_REG = "[+\\-*/]";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();
        int first;
        int second;
        long result;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            try {
                first = parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            try {
                second = parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            String operation = sc.nextLine();
            if (!Pattern.matches(OPERATION_REG, operation) || operation.length() != 1) {
                System.out.println("잘못된 연산기호를 입력하셨습니다.");
                continue;
            }

            try {
                result = cal.calculate(first, second, operation);
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }

            System.out.println("결과: " + result);
            cal.setHistory(result);

            System.out.println("결과 히스토리: " + cal.getHistory());

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if ("exit".equals(sc.nextLine())) {
                break ;
            }

            System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if ("remove".equals(sc.nextLine())) {
                cal.removeHistory();
                System.out.println("결과 히스토리: " + cal.getHistory());
            }
        }
    }

    private static int parseInt(String input) throws NumberFormatException {
        if (!Pattern.matches(NUMBER_REG, input)) {
            System.out.println("0을 포함한 양의 정수를 입력해주세요.");
            throw new NumberFormatException();
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("2,147,483,647 이하의 숫자를 입력해주세요.");
            throw e;
        }
    }
}
