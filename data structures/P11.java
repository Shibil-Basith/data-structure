import java.util.Scanner;

public class p11 {

    public static int evaluatePostfix(String expression) {
        int[] stack = new int[expression.length()];
        int top = -1;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                int operand = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operand = operand * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--; // Decrement i to account for the extra increment in the loop
                // Push the operand onto the stack
                stack[++top] = operand;
            } else if (ch == ' ') {
                continue;
            } else {
                if (top < 1) {
                    throw new IllegalArgumentException("Invalid expression: Not enough operands");
                }
                int operand2 = stack[top--];
                int operand1 = stack[top--];

                switch (ch) {
                    case '+':
                        stack[++top] = operand1 + operand2;
                        break;
                    case '-':
                        stack[++top] = operand1 - operand2;
                        break;
                    case '*':
                        stack[++top] = operand1 * operand2;
                        break;
                    case '/':
                        stack[++top] = operand1 / operand2;
                        break;
                    case '^':
                        stack[++top] = (int) Math.pow(operand1, operand2); // Cast the result to int
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
            }
        }

        if (top != 0) {
            throw new IllegalArgumentException("Invalid expression: Too many operands");
        }
        return stack[top];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a postfix expression: ");
        String postfixExpression = scanner.nextLine();
        int result = evaluatePostfix(postfixExpression);
        System.out.println("The result of the postfix expression is: " + result);
        scanner.close();
    }
}
