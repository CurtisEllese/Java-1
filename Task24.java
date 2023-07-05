// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа могут быть отрицательными.
// Даны два Deque, цифры в обратном порядке.
// [3,2,1] - пример Deque
// [5,4,3]- пример второго Deque
// 1) 123 * 345 = 42 435
// Ответ всегда - связный список, в обычном порядке
// [4,2,4,3,5] - пример ответа

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Task24 {
    static int dequeToInt(Deque<Integer> intDeq) {
        int res;
        StringBuilder stringNum = new StringBuilder();

        while (!intDeq.isEmpty()) {
            stringNum.append(intDeq.removeLast());
        }

        res = Integer.parseInt(stringNum.toString());

        return res;
    }

    static LinkedList<Integer> multiplyTwoIntInList(int number1, int number2) {
        LinkedList<Integer> res = new LinkedList<>();
        int resVal = number1 * number2;
        System.out.printf("%d * %d = %d", number1, number2, resVal);
        System.out.println();

        ArrayList<String> multiplyRes = new ArrayList<>();
        multiplyRes.addAll(Arrays.asList(Integer.toString(resVal).split("")));
        if (multiplyRes.get(0).equals("-")) {
            String negativeDigit = "-" + multiplyRes.get(1);
            multiplyRes.set(0, negativeDigit);
            multiplyRes.remove(1);
        }

        for (int i = 0; i < multiplyRes.size(); i++) {
            res.add(Integer.parseInt(multiplyRes.get(i)));
        }

        return res;
    }

    static LinkedList<Integer> additionTwoIntInList(int number1, int number2) {
        LinkedList<Integer> res = new LinkedList<>();
        int resVal = number1 + number2;
        System.out.printf("%d + %d = %d", number1, number2, resVal);
        System.out.println();

        ArrayList<String> additionRes = new ArrayList<>();
        additionRes.addAll(Arrays.asList(Integer.toString(resVal).split("")));
        if (additionRes.get(0).equals("-")) {
            String negativeDigit = "-" + additionRes.get(1);
            additionRes.set(0, negativeDigit);
            additionRes.remove(1);
        }

        for (int i = 0; i < additionRes.size(); i++) {
            res.add(Integer.parseInt(additionRes.get(i)));
        }

        return res;
    }

    static Deque<Integer> fillDequeRnd(int deqLength) {
        Deque<Integer> res = new ArrayDeque<>();
        Random rnd = new Random();

        for (int i = 0; i < deqLength; i++) {
            if (i == 0) {
                int rndNum = 0;
                do {
                    rndNum = rnd.nextInt(-9, 9);
                } while (rndNum == 0);

                res.push(rndNum);
            } else {
                res.push(rnd.nextInt(9));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Deque<Integer> deqNum1 = fillDequeRnd(3);        
        Deque<Integer> deqNum2 = fillDequeRnd(3);
        
        System.out.println("Deque 1: " + deqNum1);
        System.out.println("Deque 2: " + deqNum2);
        int num1 = dequeToInt(deqNum1);        
        int num2 = dequeToInt(deqNum2);

        
        LinkedList<Integer> multiplyResult = multiplyTwoIntInList(num1, num2);
        System.out.println("Result in Linked List: " + multiplyResult);

        LinkedList<Integer> additionResult = additionTwoIntInList(num1, num2);
        System.out.println("Result in Linked List: " + additionResult);
    }
}
