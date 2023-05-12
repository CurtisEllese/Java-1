// Task_5
// Напишите программу, которая выводит в столбик целые числа от a до b (a >= b) с шагом c. Границы включаются.
// Входные данные
// Заданы три целых числа а, b, с, где a > b
// Выходные данные
// Выведите единственное число - ответ на задачу.
// Sample Input:
// 20
// 1
// 2
// Sample Output:
// 20
// 18
// 16
// 14
// 12
// 10
// 8
// 6
// 4
// 2

import java.util.Scanner;

public class task5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = sc.nextInt();
        System.out.println("Введите второе число: ");
        int b = sc.nextInt();
        System.out.println("Введите шаг: ");
        int c = sc.nextInt();
        for (int i = a; i >= b; i -= c) {
            System.out.println(i);
        }
    }
}
