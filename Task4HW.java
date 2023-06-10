// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
// Под знаком вопроса - одинаковые цифры
// Введите уравнение: ?? + ?? = 44
// Ответ: 22 + 22 = 44

import java.util.Scanner;

public class Task4HW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите уравнение: ");
        String expression = sc.nextLine();
        Boolean flag = true;

        for (int i = 0; i < 10; i++) {
            char newChar = (char) (i + '0');
            String newExp = expression.replace('?', newChar);
            String[] words = newExp.split("\\s");
            if (Integer.parseInt(words[0]) + Integer.parseInt(words[2]) == Integer.parseInt(words[4])) {
                for (String j : words) {
                    System.out.print(j + ' ');
                }
                flag = false;
            } 
        }
        if (flag) {
            System.out.println("Решения нет.");
        }

        sc.close();
    }
}
