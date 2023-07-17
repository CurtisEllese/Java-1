import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task30 {
    public static void main(String[] args) {
        Cat cat = new Cat();

        cat.name = "Барсик";
        cat.sex = "male";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            cat.birthDate = dateFormat.parse("24.01.2023");
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
        cat.breed = "ordinary";
        cat.sprayed = false;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            cat.setTreatment(dateFormat.parse("24.06.2023"), null, Treatment.CHUMKA);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }

        System.out.println(cat);

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            cat.setTreatment(null, dateFormat.parse("29.06.2023"), null);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
        
        System.out.println(cat);

        cat.meow();
    }
}
