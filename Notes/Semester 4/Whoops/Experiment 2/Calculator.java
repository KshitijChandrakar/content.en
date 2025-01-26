class Calculator {
    public static void main(String[] args) {
        // Check if length of args array is greater than 0
        if (args.length <= 0) {
            System.out.println("No Equation Provided");
        } else {
            String equation = String.join("", args);
            float result = 0;
            String operand = "";
            char lastOperator = '+';
            for (int i = 0; i < equation.length(); i++) {
                char ch = equation.charAt(i);
                if (Character.isDigit(ch) || ch == '.') {
                    operand = operand + ch;
                } else {
                    if (!operand.isEmpty()) {
                        float num = Float.parseFloat(operand);
                        switch (lastOperator) {
                            case '+':
                                result += num;
                                break;
                            case '-':
                                result -= num;
                                break;
                            case '*':
                                result *= num;
                                break;
                            case '/':
                                result /= num;
                                break;
                        }
                    }
                    operand = "";
                    lastOperator = ch;
                }
            }
            if (!operand.isEmpty()) {
                float num = Float.parseFloat(operand);
                switch (lastOperator) {
                    case '+':
                        result += num;
                        break;
                    case '-':
                        result -= num;
                        break;
                    case '*':
                        result *= num;
                        break;
                    case '/':
                        result /= num;
                        break;
                }
            }

            System.out.println(result);
        }
    }
}
