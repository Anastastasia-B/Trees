package com.company;

public class Data {
    char symbol;
    int priority;

    Data(char symbol){
        this.symbol = symbol;
        this.priority = getPriority(symbol);
    }

    private int getPriority(char symbol){
        switch (symbol){
            case '(': return 0;
            case ')': return 1;
            case '+': return 2;
            case '-': return 2;
            case '*': return 3;
            case '/': return 3;
            case '^': return 4;
            default: return -1;
        }
    }

    boolean isOperator(){
        return this.priority >= 0;
    }

}
