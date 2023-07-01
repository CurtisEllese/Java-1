// Реализовать простой калькулятор
// Минимум -- > Условия + Цикл
// Введите число 
// Введите число 
// Выберите операцию
// 1 - сложить 
// 2 - умножить

// 4) К калькулятору из предыдущего ДЗ добавить логирование.

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task1HW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger(task1HW.class.getName());
        
        try {
            FileHandler info = new FileHandler("calc_log.txt", true);
            
            logger.addHandler(info);
            SimpleFormatter formatter = new SimpleFormatter();
            info.setFormatter(formatter);

            System.out.print("Введите первое число: ");
            int first_num = sc.nextInt();
            System.out.print("Введите второе число: ");
            int second_num = sc.nextInt();
            System.out.println("Выберите операцию:\n1 - сложить\n2 - вычесть\n3 - умножить\n4 - разделить");
            int operation = sc.nextInt();
            switch (operation) {
                case 1:
                    System.out.printf("%d + %d = %d\n", first_num, second_num, first_num + second_num);
                    logger.log(Level.INFO, String.format("%d + %d = %d", first_num, second_num, first_num + second_num));
                    break;
                case 2:
                    System.out.printf("%d - %d = %d\n", first_num, second_num, first_num - second_num);
                    logger.log(Level.INFO, String.format("%d - %d = %d", first_num, second_num, first_num - second_num));
                    break;
                case 3:
                    System.out.printf("%d * %d = %d\n", first_num, second_num, first_num * second_num);
                    logger.log(Level.INFO, String.format("%d * %d = %d", first_num, second_num, first_num * second_num));
                    break;
                case 4:
                    System.out.printf("%d / %d = %d\n", first_num, second_num, first_num / second_num);
                    logger.log(Level.INFO, String.format("%d / %d = %d", first_num, second_num, first_num / second_num));
                    break;
                default:
                    break;
                }

            sc.close();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
