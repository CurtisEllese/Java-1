// написать программу, которая проверяет правильность расстановки скобок в выражении
// Пример 1: 3 * (2 + 5) - верно
// Пример 2: [3 * (2+5) - не верно
// Пример 3: [3 * (2+5)] - верно
// Пример 4: {3} {[*] (2+5)} - верно
// Пример 5: [3> * (2+5)] - не верно

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Task27 {                                                                             
    public static boolean isBracketsCorrect(String exp, Map<Character, Character> listOfChars) { 
        Stack<Character> stack = new Stack<>();      
        for (int i = 0; i < exp.length(); i++) { 
            if (listOfChars.containsKey(exp.charAt(i))) {
                stack.push(exp.charAt(i));
            } else if (listOfChars.containsValue(exp.charAt(i))) {
                if (stack.isEmpty() || !listOfChars.get(stack.pop()).equals(exp.charAt(i))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Character> charList = new HashMap<>();
        charList.put('(', ')');
        charList.put('[', ']');
        charList.put('{', '}');
        charList.put('[', ']');
        charList.put('<', '>');

        System.out.print("Введите выражение: ");
        String expression = sc.nextLine();

        if (isBracketsCorrect(expression, charList)) {
            System.out.printf("%s - верно", expression);
        } else {
            System.out.printf("%s - не верно", expression);
        }

        sc.close();
    }
}
