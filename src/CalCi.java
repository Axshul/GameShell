import java.util.Scanner;
import java.util.LinkedList;

public class CalCi {

    static LinkedList<String> history = new LinkedList<>();

    public static double evaluateExpression(String userEquation) {
        // ANSHUL NAMDEV's CODE BASE, CANT BE COPIED , WONT BE COPIED!
        // ROLL CALL: !50
        String expr = userEquation.replaceAll("\\s+", "");
        LinkedList<Double> numbers = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if ((ch >= '0' && ch <= '9') || ch == '.') {
                currentNumber.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (currentNumber.length() == 0)
                    throw new IllegalArgumentException("Invalid expression");
                numbers.add(Double.parseDouble(currentNumber.toString()));
                currentNumber.setLength(0);
                ops.add(ch);
            } else {
                throw new IllegalArgumentException("Invalid character: " + ch);
            }
        }
        if (currentNumber.length() > 0)
            numbers.add(Double.parseDouble(currentNumber.toString()));

        int i = 0;
        while (i < ops.size()) {
            char op = ops.get(i);
            if (op == '*' || op == '/') {
                double a = numbers.get(i);
                double b = numbers.get(i + 1);
                double res;
                if (op == '*') res = a * b;
                else {
                    if (b == 0) throw new ArithmeticException("Division by zero");
                    res = a / b;
                }
                numbers.set(i, res);
                numbers.remove(i + 1);
                ops.remove(i);
            } else {
                i++;
            }
        }

        i = 0;
        while (i < ops.size()) {
            char op = ops.get(i);
            double a = numbers.get(i);
            double b = numbers.get(i + 1);
            double res;
            if (op == '+') res = a + b;
            else res = a - b;
            numbers.set(i, res);
            numbers.remove(i + 1);
            ops.remove(i);
        }

        return numbers.get(0);
    }

    public static void addToHistory(String entry) {
        if (history.size() == 10)
            history.removeFirst();
        history.add(entry);
    }

    public static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("History is empty.");
            return;
        }

        for (String h : history)
            System.out.println(h);
    }

    public static void LogicalState(String userEquation) {
        try {
            double solution = evaluateExpression(userEquation);
            String result = userEquation + " = " + solution;
            addToHistory(result);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        boolean CalCiActive = true;

        System.out.println("CalCI For The Next Generation you!");

        while (CalCiActive) {
            System.out.print("> ");
            String UserEquation = Scan.nextLine();

            if (UserEquation.equals("/exit")) {
                System.out.println("BYE BYE!");
                CalCiActive = false;
                continue;
            }

            if (UserEquation.equals("/history")) {
                showHistory();
                continue;
            }

            LogicalState(UserEquation);
        }

        Scan.close();
    }
}
