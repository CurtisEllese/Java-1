// 2) Вывести все простые числа от 1 до 1000

public class Task3HW {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println("Простые числа от 1 до " + n + ":");

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
