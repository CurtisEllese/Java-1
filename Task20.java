// Замерьте время, за которое в Array List добавится 1000000 элементов
// Замерьте время, за которое в Linked List добавится 1000000 элементов
// Сравнить

import java.util.ArrayList;
import java.util.LinkedList;

public class Task20 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            al.add(0, 0);
        }
        long timeStop  = System.currentTimeMillis();
        long res = timeStop - timeStart;
        System.out.println(res);


        LinkedList<Integer> linkedList = new LinkedList<>();
        long timeStart1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, 0);
        }
        long timeStop1  = System.currentTimeMillis();
        long res1 = timeStop1 - timeStart1;
        System.out.println(res1);
    }
}
