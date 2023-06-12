// Дано четное число N (>0) и символы с1 и с2. Написать метод, который вернет строку длинной N, которая состоит из чередующихся 
// символов с1 и с2, начиная с с1.

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите четное положительное число: ");
        int length = sc.nextInt();
        System.out.print("Введите первый символ: ");
        char firstChar = sc.next().charAt(0);
        System.out.print("Введите второй символ: ");
        char secondChar = sc.next().charAt(0);
        for (int i = 0; i < length/2; i++) {
                sb.append(firstChar).append(secondChar);
        }

        System.out.println(sb);

        sc.close();
    }
}
