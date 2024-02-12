package Package1;

import java.util.ArrayList;

interface Expression{
    public int interpret();
}
class TerminalExpression implements Expression{
    int value;
    public TerminalExpression(int value){
        this.value = value;
    }
    @Override
    public int interpret() {
        return this.value;
    }
}
class NonTerminalExpression implements Expression{
    Expression expression1;
    Expression expression2;
    public NonTerminalExpression(Expression expression1, Expression expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
    @Override
    public int interpret() {
        return expression1.interpret()+expression2.interpret();
    }
}

public class Test {
    public static void main(String[] args) {
        String expression = "10+5+20";
        char[] charArray = expression.toCharArray();
        ArrayList<String> expressionList = new ArrayList<>();
        String text = "";
        for(char c : charArray){
            if(Character.isDigit(c)){
                text += c;
            }else{
                expressionList.add(text);
                text = "";
                expressionList.add(String.valueOf(c));
            }
        }
        expressionList.add(text);

        int output = Integer.parseInt(expressionList.get(0));
        for(int i = 0; i < expressionList.size(); i++){
            if(expressionList.get(i).equals("+")){
                int valueNext = Integer.parseInt(expressionList.get(i + 1));
                output += valueNext;
            }
        }
        System.out.println(output);

        Expression e1 = new TerminalExpression(10);
        Expression e2 = new NonTerminalExpression(e1, e3);
        Expression e3 = new TerminalExpression(5);
        Expression e5 = new NonTerminalExpression(e2, e5);
        Expression e6 = new TerminalExpression(8);
    }
}
