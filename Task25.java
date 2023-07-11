// Создать структуру для хранения номеров паспортов и фамилий сотрудников организаций
// 123456 Иванов
// 345674 Рыбаков
// 235532 Иванов
// 758493 Смолов
// 372893 Иванов
// Вывести данные по сотрудникам с фамилией Иванов 

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Task25 {
    public static void main(String[] args) {
        Map<Integer, String> employees = new HashMap<>();
        employees.put(123456, "Иванов");        
        employees.put(345674, "Рыбаков");
        employees.put(235532, "Иванов");
        employees.put(758493, "Смолов");
        employees.put(372893, "Иванов");

        for (Entry<Integer, String> i : employees.entrySet()) {
            if (i.getValue().equals("Иванов")) {
                System.out.println(i);
            }
        }
    }
}
