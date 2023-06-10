// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class Task2HW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число: ");
        int num = sc.nextInt();
        System.out.println("Выберите операцию:\n1 - Вычислить n-ое треугольного числa\n2 - Вычислить факториал");
        int operation = sc.nextInt();
        switch (operation) {
            case 1:
                int triangleNumRes = 0;
                for (int i = 1; i <= num; i++) {
                    triangleNumRes += i;
                }
                System.out.println("Результат = " + triangleNumRes);
                break;
            case 2:
                int factorialRes = 1;
                for (int i = 1; i <= num; i++) {
                    factorialRes *= i;
                }
                System.out.printf("!%d = %d\n", num, factorialRes);
                break;
        
            default:
                break;
        }
        sc.close();
    }
}
