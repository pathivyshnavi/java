import java.util.*;

public class ExpressionEvaluator1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        System.out.println("Enter values and operators. Type 'done' to finish.");

        boolean expectingValue = true;
        while (true) {
            if (expectingValue) {
                System.out.print("Enter value or expression: ");
                String input = sc.next();
                if (input.equalsIgnoreCase("done")) break;
                try {
                    int value = evaluateSimpleExpression(input);
                    values.add(value);
                    expectingValue = false;
                } catch (Exception e) {
                    System.out.println("Invalid expression or value. Try again.");
                }
            } else {
                System.out.print("Enter operator (+, -, *, /): ");
                String op = sc.next();
                if (op.equalsIgnoreCase("done")) break;
                if (op.matches("[+\\-*/]")) {
                    operators.add(op);
                    expectingValue = true;
                } else {
                    System.out.println("Invalid operator. Try again.");
                }
            }
        }

        int result = calculateExpression(values, operators);
        System.out.println("Result of expression: " + result);

        while (true) {
            System.out.println("\nChoose display format:");
            System.out.println("1. ArrayList");
            System.out.println("2. LinkedList");
            System.out.println("3. Queue");
            System.out.println("Type 'exit' to finish.");
            System.out.print("Your choice: ");
            String choice = sc.next();

            if (choice.equals("1")) {
                arrayListDisplay(values);
            } else if (choice.equals("2")) {
                linkedListOperations(values, operators, sc);
            } else if (choice.equals("3")) {
                queueOperations(values, sc);
            } else if (choice.equalsIgnoreCase("exit")) {
                System.out.print("\nDo you want to perform another operation? (yes/no): ");
                String again = sc.next();
                if (!again.equalsIgnoreCase("yes")) break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        System.out.println("Thank you!");
    }

    // Evaluate arithmetic expression with support for +, -, *, /, and parentheses
    public static int evaluateSimpleExpression(String expr) throws Exception {
        return new ExpressionParser(expr).parse();
    }

    static class ExpressionParser {
        private final String input;
        private int pos = -1;
        private int ch;

        ExpressionParser(String input) {
            this.input = input;
        }

        private void nextChar() {
            pos++;
            ch = (pos < input.length()) ? input.charAt(pos) : -1;
        }

        private boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        public int parse() throws Exception {
            nextChar();
            int x = parseExpression();
            if (pos < input.length()) throw new Exception("Unexpected: " + (char)ch);
            return x;
        }

        private int parseExpression() throws Exception {
            int x = parseTerm();
            for (;;) {
                if (eat('+')) x += parseTerm();
                else if (eat('-')) x -= parseTerm();
                else return x;
            }
        }

        private int parseTerm() throws Exception {
            int x = parseFactor();
            for (;;) {
                if (eat('*')) x *= parseFactor();
                else if (eat('/')) {
                    int divisor = parseFactor();
                    if (divisor == 0) throw new Exception("Division by zero");
                    x /= divisor;
                }
                else return x;
            }
        }

        private int parseFactor() throws Exception {
            if (eat('+')) return parseFactor();
            if (eat('-')) return -parseFactor();

            int x;
            int startPos = this.pos;
            if (eat('(')) {
                x = parseExpression();
                if (!eat(')')) throw new Exception("Missing closing parenthesis");
            } else if ((ch >= '0' && ch <= '9')) {
                while ((ch >= '0' && ch <= '9')) nextChar();
                String numberStr = input.substring(startPos, this.pos);
                try {
                    x = Integer.parseInt(numberStr);
                } catch (NumberFormatException nfe) {
                    throw new Exception("Invalid number: " + numberStr);
                }
            } else {
                throw new Exception("Unexpected character: " + (char)ch);
            }
            return x;
        }
    }

    public static int calculateExpression(List<Integer> values, List<String> operators) {
        if (values.isEmpty()) return 0;
        int result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            String op = operators.get(i - 1);
            int val = values.get(i);
            switch (op) {
                case "+": result += val; break;
                case "-": result -= val; break;
                case "*": result *= val; break;
                case "/": result = val == 0 ? result : result / val; break;
            }
        }
        return result;
    }

    public static void arrayListDisplay(List<Integer> values) {
        System.out.println("Values in ArrayList: " + values);
        List<Integer> sorted = new ArrayList<>(values);
        Collections.sort(sorted);
        System.out.println("Sorted: " + sorted);
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int val : sorted) {
            if (val % 2 == 0) even.add(val);
            else odd.add(val);
        }
        System.out.println("Even Numbers: " + even);
        System.out.println("Odd Numbers: " + odd);
    }

    public static void linkedListOperations(List<Integer> values, List<String> operators, Scanner sc) {
        LinkedList<Integer> list = new LinkedList<>(values);
        List<String> ops = new ArrayList<>(operators);
        boolean done = false;
        while (!done) {
            System.out.println("LinkedList: " + list);
            System.out.println("Operators: " + ops);
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Done");
            System.out.print("Choose operation: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter value to add: ");
                    int val = sc.nextInt();
                    System.out.print("Enter operator before this value: ");
                    String op = sc.next();
                    list.add(val);
                    ops.add(op);
                    int resAdd = calculateExpression(list, ops);
                    System.out.println("Updated result after add: " + resAdd);
                    break;
                case 2:
                    System.out.print("Enter index to update (0-based): ");
                    int idx = sc.nextInt();
                    if (idx < 0 || idx >= list.size()) {
                        System.out.println("Invalid index");
                        break;
                    }
                    System.out.print("Enter new value: ");
                    list.set(idx, sc.nextInt());
                    int resUpdate = calculateExpression(list, ops);
                    System.out.println("Updated result after update: " + resUpdate);
                    break;
                case 3:
                    System.out.print("Enter index to delete (0-based): ");
                    int delIdx = sc.nextInt();
                    if (delIdx < 0 || delIdx >= list.size()) {
                        System.out.println("Invalid index");
                        break;
                    }
                    list.remove(delIdx);
                    if (delIdx > 0) ops.remove(delIdx - 1);
                    else if (!ops.isEmpty()) ops.remove(0);
                    int resDel = calculateExpression(list, ops);
                    System.out.println("Updated result after delete: " + resDel);
                    break;
                case 4:
                    done = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        int updatedResult = calculateExpression(list, ops);
        System.out.println("Final updated result: " + updatedResult);
    }

    public static void queueOperations(List<Integer> values, Scanner sc) {
        System.out.print("Enter queue size: ");
        int size = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int rotations = 0;
        for (int val : values) {
            if (queue.size() < size) {
                queue.add(val);
            } else {
                queue.poll();
                rotations++;
                queue.add(val);
            }
        }

        System.out.println("Final queue: " + queue);
        System.out.println("Total rotations: " + rotations);
    }
}

