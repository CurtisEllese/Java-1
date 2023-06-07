// Написать программу, которая запросит пользователя ввести <Имя> в консоли.
// Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”
import java.util.Scanner;
public class Task1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.print("Введите имя пользователя: ");
        String name = sc.nextLine();
        System.out.println("Привет, " + name);
    }
}