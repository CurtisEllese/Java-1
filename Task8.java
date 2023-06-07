// Дан массив двоичных чисел, например [1,1,0,1,1,1], 
// вывести максимальное количество подряд идущих 1.
public class Task8 {
    public static void main(String[] args) {
        int[] binaryArray = {1,1,0,1,1,1};
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == 1) {
                count++;
            } else {
                if (count > maxLength) {
                    maxLength = count;
                }
                count = 0;
            }
        }
        if (count > maxLength) maxLength = count;
        System.out.println(maxLength); 
    }
}
