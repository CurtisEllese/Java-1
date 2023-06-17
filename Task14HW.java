// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
import java.io.FileWriter;

public class Task14HW {
    public static void main(String[] args) {
        int[] arr = {4,5,2,3,66,1,8,12,56,28,0,2};

        try {
            FileWriter file = new FileWriter("log.txt");

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        file.write("Cycle " + i + "/ ");
                        file.write("Iteration " + j + "/ ");
                        for (int k = 0; k < arr.length; k++) {
                            file.write(Integer.toString(arr[k]));                    
                            file.write(" ");
                        }
                        file.write("\n");
                    }
                }
            }

            file.close();
            System.out.println("Check log file!");
        } catch (Exception e) {
            System.out.println("Oops...Something went wrong ;(");
        }
    }
}
