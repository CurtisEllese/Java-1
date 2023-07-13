// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
// Пример ввода:
// Иван 234234
// Иван 32523
// Иван 5687
// Иван: 234234, 32523, 5687

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class Task28HW {

    public static void printPhoneBook(Map<String, ArrayList<Integer>> phoneDict) {
        int count = 1;
        for (Entry<String, ArrayList<Integer>> entry : phoneDict.entrySet()) {
            System.out.printf("%d: Имя - %s, Номер(а) телефона - ", count, entry.getKey());
            for (Integer number : entry.getValue()) {
                System.out.printf("%d; ", number);
            }
            System.out.println();
            count++;
        }
    }
    
    public static String enterInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя и телефон через пробел. Пример ввода: Иван 12345");
        String res = sc.nextLine();
        return res;
    }

    public static void putInfoInDict(String info, Map<String, ArrayList<Integer>> dict) {
        String[] nameNumArr = info.split(" ");

        if (dict.containsKey(nameNumArr[0])) {
            ArrayList<Integer> numbersList = dict.get(nameNumArr[0]);
            numbersList.add(Integer.parseInt(nameNumArr[1]));
            dict.put(nameNumArr[0], numbersList);
        } else {
            ArrayList<Integer> numberList = new ArrayList<>();
            numberList.add(Integer.parseInt(nameNumArr[1]));
            dict.put(nameNumArr[0], numberList);
        }
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("1: Добавить контакт");
        System.out.println("2: Вывести всех");
        System.out.println("3: Завершить программу");
        System.out.println("Выберите действие: ");
        int action = sc.nextInt();
        System.out.println("-------------------------------------");
        
        do {
            switch (action) {
                case 1:
                    String enteredInfo = enterInfo();
                    putInfoInDict(enteredInfo, phoneBook);
                    break;
                case 2:
                    printPhoneBook(phoneBook);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            System.out.println("-------------------------------------");
            System.out.println("1: Добавить контакт");
            System.out.println("2: Вывести всех");
            System.out.println("3: Завершить программу");
            System.out.println("Выберите действие: ");
            action = sc.nextInt();
            System.out.println("-------------------------------------");
        } while (action != 3);

        sc.close();
    }
}
