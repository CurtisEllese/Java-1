// Реализовать консольное приложение, которое:
// 1) принимает от пользователя строку вида: text
// 2) нужно сохранить text в связный список
// 3) Если введено print~num, выводит строку из позиции num в связном списке и удаляет ее из списка

import java.util.LinkedList;
import java.util.Scanner;

public class Task21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        System.out.print("Введите строку: ");
        String text = sc.nextLine();
        while (text.contains("print~") == false) {
            list.add(text);
            System.out.println(list);
            System.out.print("Введите строку: ");
            text = sc.nextLine();
        }
        if (text.contains("print~")) {
            int pos = Integer.parseInt(text.split("~")[1]);
            System.out.println("Deleted item: " + list.remove(pos)); 
            System.out.println(list);
        }
        sc.close();
    }
}
