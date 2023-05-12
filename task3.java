// Task_3
// В первый день спортсмен пробежал x километров, а затем он каждый день увеличивал пробег на 10% от предыдущего значения. 
// По данному числу y определите номер дня, на который пробег спортсмена составит не менее y километров.
// Входные данные
// Программа получает на вход действительные числа x и y
// Выходные данные
// Программа должна вывести одно натуральное число.
// Sample Input:
// 10
// 20
// Sample Output:
// 9
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите кол-во километров в первый день: ");
        double x = iScanner.nextInt();
        System.out.println("Введите кол-во километров: ");
        int y = iScanner.nextInt();
        int count = 1;
        while (x < y) {
            x *= 1.1;
            count++;
        }
        System.out.println(count);
        iScanner.close();
    }
}
