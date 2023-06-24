// Реализовать простой калькулятор
// Минимум -- > Условия + Цикл
// Введите число 
// Введите число 
// Выберите операцию
// 1 - сложить 
// 2 - умножить

// 4) К калькулятору из предыдущего ДЗ добавить логирование.

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class task1HW {
    public static void main(String[] args) {
        FileWriter file = null;
        Scanner sc = new Scanner(System.in);
        
        try {
            file = new FileWriter("calc_log.txt", true);
            

            System.out.print("Введите первое число: ");
            int first_num = sc.nextInt();
            System.out.print("Введите второе число: ");
            int second_num = sc.nextInt();
            System.out.println("Выберите операцию:\n1 - сложить\n2 - вычесть\n3 - умножить\n4 - разделить");
            int operation = sc.nextInt();
            switch (operation) {
                case 1:
                    System.out.printf("%d + %d = %d\n", first_num, second_num, first_num + second_num);
                    file.write(String.format("%d + %d = %d\n", first_num, second_num, first_num + second_num));
                    break;
                case 2:
                    System.out.printf("%d - %d = %d\n", first_num, second_num, first_num - second_num);
                    file.write(String.format("%d - %d = %d\n", first_num, second_num, first_num - second_num));
                    break;
                case 3:
                    System.out.printf("%d * %d = %d\n", first_num, second_num, first_num * second_num);
                    file.write(String.format("%d * %d = %d\n", first_num, second_num, first_num * second_num));
                    break;
                case 4:
                    System.out.printf("%d / %d = %d\n", first_num, second_num, first_num / second_num);
                    file.write(String.format("%d / %d = %d\n", first_num, second_num, first_num / second_num));
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии FileWriter: " + e.getMessage());
            }
        }

        try {
            System.out.println("Если вы хотите очистить файл логов нажмите 9");
            int operation2 = sc.nextInt();
            switch (operation2) {
                case 9:
                    boolean isDeleted = new File("calc_log.txt").delete();
                    if (isDeleted) {
                        System.out.println("Файл успешно удален.");
                    } else {
                        System.out.println("Не удалось удалить файл.");
                    }
                    Files.createFile(Paths.get("calc_log.txt"));
                    System.out.println("Файл успешно создан.");
                    break;
            
                default:
                    break;
            }

            sc.close();
        } catch (IOException e) {
            System.err.println("Ошибка при удалении файла или создании нового файла: " + e.getMessage());
        }
    }
}
