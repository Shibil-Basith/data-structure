import java.util.Scanner;

public class P11 {

    // Method to evaluate the postfix expression
    public static int evaluatePostfix(String expression) {
        // Create a stack to store the operands
        int[] stack = new int[expression.length()];
        int top = -1; // Pointer to the top of the stack

        // Iterate through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                // If the character is a digit, push it onto the stack
                stack[++top] = ch - '0';
            } else if (ch == ' ') {
                // Skip spaces
                continue;
            } else {
                // The character is an operator; pop the required operands from the stack
                int operand2 = stack[top--];
                int operand1 = stack[top--];
                
                // Perform the operation and push the result back onto the stack
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
                }
            }
        }
        
        // The final result is the only value left on the stack
        return stack[top];
    }

    // Main method to test the evaluation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a postfix expression
        System.out.print("Enter a postfix expression: ");
        String postfixExpression = scanner.nextLine();

        // Evaluate the postfix expression
        int result = evaluatePostfix(postfixExpression);

        // Display the result
        System.out.println("The result of the postfix expression is: " + result);

        scanner.close();
    }
}
