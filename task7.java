// Task_7
// Дан список. Выведите те его элементы, которые встречаются в списке только один раз. 
// Элементы нужно выводить в том порядке, в котором они встречаются в списке.
// Входные данные
// Вводится список чисел. Все числа списка находятся на одной строке.
// Выходные данные
// Выведите ответ на задачу.
// Sample Input:
// [1, 2, 2, 3, 3, 3]
// Sample Output:
// 1

import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        String[] num_list = sc.nextLine().split(" ");
        
        for (int i = 0; i < num_list.length; i++) {
            int count = 0;
            if (i == 0) {
                for (int j = 1; j < num_list.length; j++) {
                    if (num_list[i].equals(num_list[j])) {
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Числo без повтора:");
                    System.out.println(num_list[i]);
                }
            } else if (i == num_list.length - 1) {
                for (int j = num_list.length - 2; j > 0; j--) {
                    if (num_list[i].equals(num_list[j])) {
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Числo без повтора:");
                    System.out.println(num_list[i]);
                }
            } else {
                for (int j = 0; j < i; j++) {
                    if (num_list[i].equals(num_list[j])) {
                        count++;
                    }
                }
                for (int j = i + 1; j < num_list.length; j++) {
                    if (num_list[i].equals(num_list[j])) {
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Числo без повтора:");
                    System.out.println(num_list[i]);
                }
            }
        }
        sc.close();
    }
}
