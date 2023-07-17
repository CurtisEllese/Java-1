// 1. Напишите метод который заполнит массив длинною 100 элементов случайными числами от 0 до 50
// 2. Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент уникальных значений в 
// данном массиве и верните его в виде числа с плавающей запятой.
// Для вычисления процента используйте формулу:
// процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Task29 {
    public static ArrayList<Integer> fillArrayRnd(int arrLen, int minVal, int maxVal) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rnd = new Random();
        
        for (int i = 0; i < arrLen - 1; i++) {
            arr.add(i, rnd.nextInt(minVal, maxVal + 1));
        }

        return arr;
    }

    public static double getAmountUniqueNums(ArrayList<Integer> arr) {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(arr);

        double result = (double) set.size() * 100 / (double) arr.size();
        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> array = fillArrayRnd(100, 0, 50);
        System.out.printf("%.2f", getAmountUniqueNums(array));
    }
}
