package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private Queue<Long> history = new LinkedList<Long>();

    public long calculate(int firstNum, int secondNum, String operator) throws ArithmeticException {
        long result = 0;

        switch (operator) {
            case "+":
                result = (long) firstNum + (long) secondNum;
                break;
            case "-":
                result = (long) firstNum - (long) secondNum;
                break;
            case "*":
                result = (long) firstNum * (long) secondNum;
                break;
            case "/":
                result = (long) firstNum / (long) secondNum;
                break;
            default:
                System.out.println("잘못된 연산기호를 입력하셨습니다.");
        }

        return result;
    }

    public void setHistory(long recent) {
        history.offer(recent);
    }

    public Queue<Long> getHistory() {
        return history;
    }

    public void removeHistory() {
        history.poll();
    }
}
