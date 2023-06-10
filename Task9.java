// Дан массив nums = [3,2,4,3,1,5,3,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

// [2,4,1,5,3,3,3,3]
// C использованием только 1 массива


// public class Task9 {
//     public static void main(String[] args) {
//         int[] nums = {3,2,4,3,1,5,3,3}; // [2.4.3. . . . .3.3.3]
//         //            0,1,2,3,4,5,6,7.8.9       0,1,2,3,4,5,6,7.8.9
//         int val = 3;
//         for (int i = 1; i < nums.length; i++) { // i = 1 < 10
//             if (nums[i - 1] == val) {
//                 nums[i - 1] = nums[i];
//                 for (int j = i; j < nums.length - 1; j++) {  // j = 1
//                     nums[j] = nums[j + 1];
//                 }
//                 nums[nums.length - 1] = val;
//             }
//         }
//         for (int i : nums) {
//             System.out.println(i);
//         }
//     }
// }

public class Task9 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 4, 3, 1, 5, 3, 3};
        int val = 3;
        int lastIndex = nums.length - 1;

        for (int i = 0; i < lastIndex;) {
            if (nums[i] == val) {
                for (int j = i; j < lastIndex; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[lastIndex] = val;
                lastIndex--;
            } else {
                i++;
            }
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
