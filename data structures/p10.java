import java.util.*;

class p10 {
    static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String args[]) {
        String infix;
        char stack[] = new char[100]; // Increased stack size
        String postfix = "";
        int top = -1;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the infix expression: ");
        infix = s.nextLine(); // Reading entire line

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } else if (c == '(') {
                stack[++top] = c;
            } else if (c == ')') {
                while (top != -1 && stack[top] != '(') {
                    postfix += stack[top--];
                }
                if (top != -1 && stack[top] == '(') {
                    top--; // Pop '('
                }
            } else {
                while (top != -1 && precedence(c) <= precedence(stack[top])) {
                    postfix += stack[top--];
                }
                stack[++top] = c;
            }
        }
        
        // Pop remaining operators from stack
        while (top != -1) {
            postfix += stack[top--];
        }

        System.out.println("Postfix Expression: " + postfix);
    }
}
