package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String str = "(A * (B + (C / D) ) )";
        str = str.replaceAll("\\s+", "");
        char[] infix = str.toCharArray();
        char[] postfix = toPostfix(infix);
        char[] prefix = translate(toPostfix(translate(infix)));
        System.out.println("Постфиксная форма: ");
        printCharArray(postfix);
        System.out.println("Префиксная форма: ");
        printCharArray(prefix);

    }

    private static char[] toPostfix(char[] infix){
        char[] postfix = new char[infix.length];
        FIFO fifo = new FIFO();
        int i = 0;
        for(char symbol_ : infix){
            /*System.out.println();
            System.out.print(symbol_);
            fifo.print();
            printCharArray(postfix);
            System.out.println();*/
            Data symbol = new Data(symbol_);
            if(!symbol.isOperator()){
                postfix[i] = symbol.symbol;
                i++;
                continue;
            }
            if(symbol.priority == 0){
                fifo.push(symbol);
                continue;
            }
            if(symbol.priority == 1){
                while (fifo.getHeadPriority() != 0){
                    postfix[i] = fifo.pull().symbol;
                    i++;
                }
                fifo.pull();
                continue;
            }
            if(fifo.getHeadPriority() != -1)
                while (symbol.priority <= fifo.getHeadPriority() && fifo.getHeadPriority() != 0){
                    postfix[i] = fifo.pull().symbol;
                    i++;
                }
            fifo.push(symbol);
        }
        while (fifo.getHeadPriority() != -1){
            postfix[i] = fifo.pull().symbol;
            i++;
        }

        return postfix;
    }

    private static void printCharArray(char[] array){
        for(char symbol : array){
            if(symbol != 0)
                System.out.print(symbol);
        }
        System.out.println();
    }

    private static char[] translate(char[] array){
        char[] result = new char[array.length];
        for(int i = 0; i < array.length; i++){
            switch (array[i]){
                case '(':
                    result[array.length - i - 1] = ')';
                    break;
                case ')':
                    result[array.length - i - 1] = '(';
                    break;
                default:
                    result[array.length - i - 1] = array[i];
            }
        }
        return result;
    }

}
