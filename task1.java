// Task_1. Улитка ползёт по вертикальному шесту высотой h метров, поднимаясь за день на a метров,
// а за ночь спускаясь на b метров. На какой день улитка доползёт до вершины шеста?
// Программа получает на вход натуральные числа h, a, b. Гарантируется, что a>b.
// Программа должна вывести одно натуральное число.
// Sample Input 10 3 2 
// Sample Output 8

import java.util.Scanner;
public class task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("h: ");
        int h = iScanner.nextInt();
        System.out.printf("a: ");
        int a = iScanner.nextInt();
        System.out.printf("b: ");
        int b = iScanner.nextInt();
        int position = 0;
        while (position + a <= h) {
            position += a - b;
        }
        System.out.printf("На %d день улитка доползёт до вершины шеста\n", position);
        iScanner.close();
  }
}