// Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет.
// Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом:
// 1. повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка  следования. (Например, add - egg изоморфны)
// 2. буква может не меняться, а остаться такой же (Например, note - code изоморфны)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task26 {                                                
    static boolean isIsomorphic(String firstStr, String secondStr) { 
        boolean res = true;                                          
        Map<Character, Character> charList = new HashMap<>();        
        for (int i = 0; i < firstStr.length(); i++) {                
            if (charList.containsKey(firstStr.charAt(i))) {
                if (!charList.get(firstStr.charAt(i)).equals(secondStr.charAt(i))) {
                    return false;
                }
            } else {
                charList.put(firstStr.charAt(i), secondStr.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первую строку: ");
        String firstLine = sc.nextLine();
        System.out.print("Введите вторую строку: ");
        String secondLine = sc.nextLine();

        while (firstLine.length() != secondLine.length()) {
            System.out.println("Введите строку с одинаковым кол-вом символов!");
            System.out.print("Введите первую строку: ");
            firstLine = sc.nextLine();
            System.out.print("Введите вторую строку: ");
            secondLine = sc.nextLine();
        }

        if (isIsomorphic(firstLine, secondLine)) {
            System.out.printf("%s и %s изоморфны\n", firstLine, secondLine);
        } else {
            System.out.printf("%s и %s НЕ изоморфны\n", firstLine, secondLine);
        }
        
        sc.close();
    }
}
