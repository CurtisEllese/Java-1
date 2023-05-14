// Реализовать простой калькулятор
// Минимум -- > Условия + Цикл
// Введите число 
// Введите число 
// Выберите операцию
// 1 - сложить 
// 2 - умножить
import java.util.Scanner;

public class task1HW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int first_num = sc.nextInt();
        System.out.println("Введите второе число: ");
        int second_num = sc.nextInt();
        System.out.println("Выберите операцию:\n1 - сложить\n2 - вычесть\n3 - умножить\n4 - разделить");
        int operation = sc.nextInt();
        switch (operation) {
            case 1:
                System.out.printf("%d + %d = %d\n", first_num, second_num, first_num + second_num);
                break;
            case 2:
                System.out.printf("%d - %d = %d\n", first_num, second_num, first_num - second_num);
                break;
            case 3:
                System.out.printf("%d * %d = %d\n", first_num, second_num, first_num * second_num);
                break;
            case 4:
                System.out.printf("%d / %d = %d\n", first_num, second_num, first_num / second_num);
                break;
            default:
                break;
        }
        sc.close();
    }
}
