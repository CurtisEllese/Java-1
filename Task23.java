// Написать метод, который принимает массив элементов, помещает их в стэк и выводит в консоль содержимое стэка 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Task23 {
    public static Stack<Integer> fillStack(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int i : array) {
            stack.push(i);
        }
        return stack;
    }

    public static Queue<Integer> fillQueue(int[] array) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (Integer i : array) {
            queue.add(i);
        }

        return queue;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = new int[10];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
        }

        System.out.println(fillStack(arr));
        System.out.println(fillQueue(arr));
    }
}