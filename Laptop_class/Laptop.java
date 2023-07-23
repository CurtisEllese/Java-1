package Laptop_class;

public class Laptop {
    Manufacturer manufacturer;
    RAM ram;
    CPU cpu;
    Storage ssd;
    OS os;
    Performance_cores performance_cores;
    Color color;
    int price;
    int amount_in_storage;

    public Laptop(Manufacturer manufacturer, RAM ram, CPU cpu, Color color, OS os, 
                  Storage ssd, Performance_cores performance_cores, int price, int amount_in_storage) {
        this.manufacturer = manufacturer;
        this.ram = ram;
        this.cpu = cpu;
        this.ssd = ssd;
        this.performance_cores = performance_cores;
        this.price = price;
        this.color = color;
        this.os = os;
        this.amount_in_storage = amount_in_storage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------------------------------------\n");
        sb.append("Производитель: ").append(this.manufacturer).append("\n");
        sb.append("Объем ОЗУ: ").append(this.ram.getSizeLabel()).append("\n");
        sb.append("Процессор: ").append(this.cpu).append("\n");
        sb.append("Объем памяти: ").append(this.ssd.getSizeLabel()).append("\n");
        sb.append("Количество ядер: ").append(this.performance_cores.getAmount()).append("\n");
        sb.append("Цена: ").append(this.price).append(" KZT\n");
        sb.append("Цвет: ").append(this.color).append("\n");
        sb.append("Операционная система: ").append(this.os).append("\n");
        sb.append("Количество на складе: ").append(this.amount_in_storage).append("\n");
        sb.append("-------------------------------------------\n");
        return sb.toString();
    }


    public int calculate_discounted_price(int discount_percentage) {
        int discount = (int) (this.price * (discount_percentage * 0.01));
        int result = this.price - discount;
        return result;
    }

    public boolean check_availability(int need_amount) {
        return need_amount <= amount_in_storage;
    }

    public void purchase(int need_amount) {
        this.amount_in_storage = this.amount_in_storage - need_amount;
        System.out.println("Спасибо за покупку!");
    }
}
