// Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое 
// является информационной системой ветеринарной клиники
// Поля: 
// Str Name - имя
// Int Age - возраст
// Bool Graft - привит ли он?
// Bool fur - есть ли шерстка у кота?
// Str color - если есть шерстка, то какого цвета?
// Str sex - пол
// Bool sprayed - стерилизован ли?
// Str breed - порода кота
// Int id
// lastVaccinationDate

// Методы:
// Метод прививки кота - cat treatment
// Лечение Treatment дата/дата оконч/болезнь

import java.text.SimpleDateFormat;
import java.util.Date;


public class Cat {
    private int id;
    public String name;
    public Date birthDate;
    public String sex;
    public boolean sprayed;
    public String breed;
    public Date lastVaccinationDate;
    public Treatment treatment;
    public Date treatmentDate;

    public void vaccination(Date date) {
        this.lastVaccinationDate = date;
    }

    public void setTreatment(Date startDate, Date endDate, Treatment treatment) {
        if (endDate != null) {
            this.treatmentDate = null;
            this.treatment = null;
        }
        else {
            this.treatmentDate = startDate;
            this.treatment = treatment;
        }
    }

    public void meow() {
        System.out.printf("Кот %s мяукнул 5 раз", this.name);
    }

    @Override
    public String toString() {
        if (treatmentDate != null) {
            String dateFormatPattern = "dd.MM.yyyy";
    
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
            String formattedDate = dateFormat.format(this.treatmentDate);
            return String.format("%s %s %s", this.name, formattedDate, this.treatment);
        } else {
            return String.format("%s не болен", this.name);
        }
    }
}
