// Task_6
// Вводится массив (сначала количество элементов, потом сами элементы). Найдите сумму его элементов с чётными индексами и выведите её. 
// А потом выведите числа, которые суммировались.
// Sample Input:
// 4
// 1
// 2
// 3
// 4
// Sample Output:
// 4
// 1
// 3
import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Размер массива:");
        int size = sc.nextInt();
        int sum_even_nums = 0;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите элемент массива:");
            arr[i] = sc.nextInt();
            if (i % 2 == 0) {
                sum_even_nums += arr[i];
            }
        }
        System.out.println();
        System.out.println(sum_even_nums);
        System.out.println();
        for (int i = 0; i < arr.length; i += 2) {
            System.out.println(arr[i]);
        }
        sc.close();
    }
}