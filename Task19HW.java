// Пусть дан произвольный список целых чисел.
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее ариф. значение

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Task19HW {
    static int findMin(ArrayList<Integer> list) {
        int res = 0;

        for (Integer item : list) {
            if (item < res) {
                res = item;
            }
        }
        return res;
    }

    static int findMax(ArrayList<Integer> list) {
        int res = 0;

        for (Integer item : list) {
            if (item > res) {
                res = item;
            }
        }
        return res;
    }

    static Double findAverageDbl(ArrayList<Integer> list) {
        Double res = 0.0;

        for (Integer item : list) {
            res += item;
        }
        res /= list.size();
        return res;
    }

    static void DelEvenNums(ArrayList<Integer> list) {
        Iterator<Integer> col = list.iterator();

        while (col.hasNext()) {
            if (col.next() % 2 == 0) {
                col.remove();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1,3,5,57,32,136,84,121,231,3,55,2,1,1,0,6,3,-12));

        int min = findMin(intList);
        System.out.println("min: " + min);

        int max = findMax(intList);
        System.out.println("max: " + max);

        Double average = findAverageDbl(intList);
        System.out.println("average: " + average);

        DelEvenNums(intList);
        System.out.println(intList);
    }
}
