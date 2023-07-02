// Заполнить список десятью случайными числами, отсортировать его с помощью метода sort() и вывести на экран.

import java.util.ArrayList;
import java.util.Random;

public class Task18 {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            intList.add(rnd.nextInt(100));
        }

        intList.sort(null);

        System.out.println(intList);
    }
}
