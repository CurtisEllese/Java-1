// Напишите метод, который сжимает строку
// Ввод: aaaabbbcdd
// Вывод: a4b3cd2

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder resString = new StringBuilder();
        System.out.print("Введите строку: ");
        String inputString = sc.nextLine();
        int count = 1;
        int lastIndex = inputString.length()-1;

        for (int i = 0; i < lastIndex; i++) {
            if (inputString.charAt(i) == inputString.charAt(i + 1)) {
                count++;
            } else if (count != 1) {
                resString.append(inputString.charAt(i)).append(count);
                count = 1;
            } else {
                resString.append(inputString.charAt(i));
            }
        }
        if (count != 1) {
                resString.append(inputString.charAt(lastIndex)).append(count);
                count = 1;
        } else {
            resString.append(inputString.charAt(lastIndex));
        }

        System.out.println(resString);
        sc.close();
    }
}
