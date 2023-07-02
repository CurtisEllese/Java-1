// Создать список типа ArrayList. Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.
// Сделать два варианта: простой и с использованием итератора

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Task17 {
    static void iterDeleteNumsFromArrList(ArrayList list) {
        Iterator col = list.iterator();
        
        while (col.hasNext()) {
            if (col.next() instanceof Integer) {
                col.remove();
            }
        }
    }

    // static ArrayList<String> deleteNumsFromArrList(ArrayList list) {
    //     ArrayList<String> result = new ArrayList<>();

    //     for (int i = 0; i < list.size(); i++) {
    //         if (list.get(i) instanceof Integer == false) {
    //             result.add((String) list.get(i));
    //         }
    //     }
    //     return result;
    // }

    static void deleteNumsFromArrList(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Integer) {
                list.remove(i);
                i--;
            }
        }
    }
    
    static void printStrArrayList(ArrayList<String> list) {
        for (String item : list) {
            System.out.print(item + " ");
        }
    }
    public static void main(String[] args) {
        ArrayList arr = new ArrayList<>(Arrays.asList(1, "Hi", 2, 4, "SSS", 798, "afk"));
        // ArrayList<String> newArr = deleteNumsFromArrList(arr);
        // printStrArrayList(newArr);
        deleteNumsFromArrList(arr);
        printStrArrayList(arr);
        System.out.println();
        iterDeleteNumsFromArrList(arr);
        printStrArrayList(arr);
    }
}
