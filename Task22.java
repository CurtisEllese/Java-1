// Реализовать консольное приложение, которое:
// 1) Принимает от пользователя и "запоминает" строки
// 2) Если введено print,то выводит строки в обратном порядке

import java.util.Scanner;
import java.util.Stack;

public class Task22 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String text = sc.nextLine();

        while (!text.equalsIgnoreCase("print")) {
            stack.push(text);
            System.out.println(stack);
            System.out.print("Введите строку: ");
            text = sc.nextLine();
        }

        if (text.equalsIgnoreCase("print")) {
            while (stack.empty() == false) {
                System.out.println(stack.pop());
            }
        }

        sc.close();
    }
}
