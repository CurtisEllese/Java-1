// Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. Вывести название каждой планеты и 
// кол-во его повторений в списке.

import java.util.ArrayList;

public class Task16 {
    public static void main(String[] args) {
        ArrayList<String> usedPlanets = new ArrayList<>();
        String[] solarSysPlanets = {"Меркурий", "Марс", "Земля", "Сатурн", "Венера", "Земля", "Сатурн", "Марс", "Юпитер", "Земля", "Меркурий", "Сатурн", "Юпитер", "Уран", "Марс", "Нептун", "Земля"};
        int count = 0;

        for (int i = 0; i < solarSysPlanets.length; i++) {
            if (usedPlanets.contains(solarSysPlanets[i]) == false) {
                for (String planet : solarSysPlanets) {
                    if (solarSysPlanets[i] == planet) {
                        count++;
                    }
                }
                System.out.println(solarSysPlanets[i] + ": " + count);
                count = 0;
                usedPlanets.add(solarSysPlanets[i]);
            }
        }
    }
}
