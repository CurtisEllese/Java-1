// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".
// import java.util.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Task13HW {
    public static void main(String[] args) {
        StringBuilder sqlQuery = new StringBuilder();
        String sqlString = "select * from students";
        HashMap<String, String> jsonHashMap = new HashMap<>();
        String[] jsonStrings = {"name", "Ivanov", "country", "Russia", "city", "Moscow", "age", "null"};
        
        for (int i = 0; i < jsonStrings.length-1; i += 2) {
            if (jsonStrings[i+1] != "null") {
                jsonHashMap.put(jsonStrings[i], jsonStrings[i+1]);
            }
        }
        
        int dictLength = jsonHashMap.size();
        int count = 0;

        if (dictLength == 0) {
            sqlQuery.append(sqlString);
        } else {
            sqlQuery.append(sqlString).append(" WHERE ");
            for (Map.Entry<String, String> entry : jsonHashMap.entrySet()) {            
                sqlQuery.append(entry.getKey()).append(" = ").append(entry.getValue());
                count++;
                if (count < dictLength) {
                    sqlQuery.append(" AND ");
                }
            }
        }

        System.out.println(sqlQuery);
    }
}
