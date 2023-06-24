// 3) Дана json-строка (можно сохранить в файл и читать из файла)
// Написать метод(ы), который распарсит json и, используя StringBuilder, 
// создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
import java.io.FileReader;
import java.io.BufferedReader;

public class Task15HW {
    public static void main(String[] args) {
        String filePath = "task15json.txt";
        
        try (FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader)) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            String fileContent = sb.toString();
            fileContent = fileContent.replace("\n", "").replace(" ", "").replace("}", "");
            fileContent = fileContent.substring(1, fileContent.length() - 1);
            String[] fileData = fileContent.split(",");
            
            StringBuilder resString = new StringBuilder();
            for (String data : fileData) {
                String[] keyValue = data.split(":", 2);
                String value = keyValue[1].replace("\"", "").replace("}", "");
                if (keyValue[0].contains("фамилия")) {
                    resString.append("Студент ").append(value);
                } else if (keyValue[0].contains("оценка")) {
                    resString.append(" получил(a) ").append(value);
                } else if (keyValue[0].contains("предмет")) {
                    resString.append(" по предмету ").append(value);
                    System.out.println(resString);
                    resString.setLength(0);
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
