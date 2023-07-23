package Laptop_class;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook
// Например: “Введите цифру, соответствующую необходимому критерию: 
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Класс сделать в отдельном файле
// приветствие 
// Выбор параметра
// выбор конкретнее
// вывод подходящих

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Task31HW {
    // Варианты меню
    private static final int SHOW_ALL_LAPTOPS = 1;
    private static final int SHOW_FILTER_OPTIONS = 2;
    private static final int EXIT_PROGRAM = 3;

    // Другие константы
    private static final String PROMO_CODE = "GEEKBRAINS";
    private static final int PROMO_DISCOUNT_PERCENTAGE = 30;

    // Метод покупки ноутбука
    public static void buyLaptop(Laptop neededLaptop) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("У вас есть промокод?(Введите число нужного варианта ответа)\n1 - Да\n2 - Нет");
        int promoAnswer;
        try {
            promoAnswer = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Ошибка: Введите корректное число!");
        }

        if (promoAnswer == 1) {
            System.out.println("Введите промокод:");
            String promocodeAnswer = scanner.nextLine();
            if (promocodeAnswer.toUpperCase().equals(PROMO_CODE)) {
                System.out.println("Поздравляем! У вас есть скидка 30%!");
                int discounted_price = neededLaptop.calculate_discounted_price(PROMO_DISCOUNT_PERCENTAGE);
                System.out.printf("Цена с учетом скидки %d%% = %d \n", PROMO_DISCOUNT_PERCENTAGE, discounted_price);
            } else {
                System.out.println("Промокод недействительный");
            }
        }

        System.out.print("Введите нужное кол-во ноутбуков: ");
        int neededAmount;
        try {
            neededAmount = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Некорректное число. Покупка отменена.");
        }

        if (neededLaptop.check_availability(neededAmount)) {
            System.out.println("Нужное кол-во ноутбуков есть!");
            neededLaptop.purchase(neededAmount);
            System.out.printf("Остаток на складе после покупки: %d\n", neededLaptop.amount_in_storage);
        } else {
            System.out.println("Нужное кол-во ноутбуков отсутствует!");
        }
    }

    // Метод получения ноутбуков, соответстующих критериям фильтрации
    public static HashSet<Laptop> getFilteredLaptops(HashMap<String, String> filters, HashSet<Laptop> laptopsSet) {
        HashSet<Laptop> filteredLaptops = new HashSet<>(laptopsSet);
        if (filters.containsKey("ram")) {
            String ramFilter = filters.get("ram");
            filteredLaptops.removeIf(laptop -> !ramFilter.equals(laptop.ram.getSizeLabel()));
        }

        if (filters.containsKey("storage")) {
            String storageFilter = filters.get("storage");
            filteredLaptops.removeIf(laptop -> !storageFilter.equals(laptop.ssd.getSizeLabel()));
        }

        if (filters.containsKey("os")) {
            String osFilter = filters.get("os");
            filteredLaptops.removeIf(laptop -> !osFilter.toUpperCase().equals(laptop.os.toString()));
        }

        if (filters.containsKey("color")) {
            String colorFilter = filters.get("color");
            filteredLaptops.removeIf(laptop -> !laptop.color.toString().equals(colorFilter.toUpperCase()));
        }

        if (filters.containsKey("manufacturer")) {
            String manufacturerFilter = filters.get("manufacturer");
            filteredLaptops
                    .removeIf(laptop -> !laptop.manufacturer.toString().equals(manufacturerFilter.toUpperCase()));
        }
        return filteredLaptops;
    }

    // Метод получения параметров фильтрации
    public static HashMap<String, String> getFilters() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> filters = new HashMap<>();

        int criteria;
        do {
            System.out.println(
                    "Введите цифру, соответствующую необходимому критерию:\n1 - ОЗУ\n2 - Объем ЖД\n3 - Операционная система\n4 - Цвет\n5 - Производитель\n6 - Показать ноутбуки, соответствующие критериям");
            criteria = scanner.nextInt();
            switch (criteria) {
                case 1:
                    filters.put("ram", selectRAMSize(scanner));
                    break;
                case 2:
                    filters.put("storage", selectStorageSize(scanner));
                    break;
                case 3:
                    filters.put("os", selectOS(scanner));
                    break;
                case 4:
                    filters.put("color", selectColor(scanner));
                    break;
                case 5:
                    filters.put("manufacturer", selectManufacturer(scanner));
                    break;
                default:
                    break;
            }
        } while (criteria != 6);

        return filters;
    }

    private static String selectRAMSize(Scanner scanner) {
        System.out.println(
                "Выберите необходимый объем ОЗУ:\n1 - 4 GB\n2 - 6 GB\n3 - 8 GB\n4 - 12 GB\n5 - 16 GB\n6 - 32 GB");
        int ramFilter = scanner.nextInt();

        switch (ramFilter) {
            case 1:
                return "4 GB";
            case 2:
                return "6 GB";
            case 3:
                return "8 GB";
            case 4:
                return "12 GB";
            case 5:
                return "16 GB";
            case 6:
                return "32 GB";
            default:
                return null;
        }
    }

    private static String selectStorageSize(Scanner scanner) {
        System.out.println(
                "Выберите необходимый объем SSD/HDD:\n1 - 128 GB\n2 - 256 GB\n3 - 500 GB\n4 - 512 GB\n5 - 1000 GB\n6 - 1024 GB\n7 - 2000 GB");
        int storageFilter = scanner.nextInt();

        switch (storageFilter) {
            case 1:
                return "128 GB";
            case 2:
                return "256 GB";
            case 3:
                return "500 GB";
            case 4:
                return "512 GB";
            case 5:
                return "1000 GB";
            case 6:
                return "1024 GB";
            case 7:
                return "2000 GB";
            default:
                return null;
        }
    }

    private static String selectOS(Scanner scanner) {
        System.out.println("Выберите необходимую ОС:\n1 - Windows\n2 - Linux\n3 - macOS");
        int osFilter = scanner.nextInt();

        switch (osFilter) {
            case 1:
                return "Windows";
            case 2:
                return "Linux";
            case 3:
                return "macOS";
            default:
                return null;
        }
    }

    private static String selectColor(Scanner scanner) {
        System.out.println(
                "Выберите необходимый цвет:\n1 - Black\n2 - Space gray\n3 - Gray\n4 - White\n5 - Pink\n6 - Gold");
        int colorFilter = scanner.nextInt();

        switch (colorFilter) {
            case 1:
                return "Black";
            case 2:
                return "Space_gray";
            case 3:
                return "Gray";
            case 4:
                return "White";
            case 5:
                return "Pink";
            case 6:
                return "Gold";
            default:
                return null;
        }
    }

    private static String selectManufacturer(Scanner scanner) {
        System.out.println(
                "Выберите необходимого производителя:\n1 - ACER\n2 - AORUS\n3 - APPLE\n4 - ASUS\n5 - DELL\n6 - GIGABYTE\n7 - HP\n8 - HUAWEI\n9 - LENOVO\n10 - MSI\n11 - XIAOMI");
        int manufacFilter = scanner.nextInt();

        switch (manufacFilter) {
            case 1:
                return "ACER";
            case 2:
                return "AORUS";
            case 3:
                return "APPLE";
            case 4:
                return "ASUS";
            case 5:
                return "DELL";
            case 6:
                return "GIGABYTE";
            case 7:
                return "HP";
            case 8:
                return "HUAWEI";
            case 9:
                return "LENOVO";
            case 10:
                return "MSI";
            case 11:
                return "XIAOMI";
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Laptop> laptops = new HashSet<>();

        Laptop vivoBook_Pro = new Laptop(Manufacturer.ASUS, RAM.SIZE_16GB, CPU.INTEL, Color.BLACK, OS.WINDOWS,
                Storage.SIZE_512GB, Performance_cores.PIECES8, 502890, 13);
        laptops.add(vivoBook_Pro);

        Laptop legion = new Laptop(Manufacturer.LENOVO, RAM.SIZE_16GB, CPU.INTEL, Color.GRAY, OS.LINUX,
                Storage.SIZE_2000GB, Performance_cores.PIECES8, 1502890, 3);
        laptops.add(legion);

        Laptop macBook_Pro = new Laptop(Manufacturer.APPLE, RAM.SIZE_16GB, CPU.APPLE, Color.SPACE_GRAY, OS.MACOS,
                Storage.SIZE_512GB, Performance_cores.PIECES8, 1199890, 50);
        laptops.add(macBook_Pro);

        Laptop asusZenBook = new Laptop(Manufacturer.ASUS, RAM.SIZE_8GB, CPU.INTEL, Color.GRAY, OS.WINDOWS, 
                Storage.SIZE_512GB, Performance_cores.PIECES4, 749990, 25);
        laptops.add(asusZenBook);

        Laptop dellXPS = new Laptop(Manufacturer.DELL, RAM.SIZE_16GB, CPU.INTEL, Color.SPACE_GRAY, OS.WINDOWS, 
                Storage.SIZE_1000GB, Performance_cores.PIECES8, 1299990, 15);
        laptops.add(dellXPS);

        Laptop hpSpectre = new Laptop(Manufacturer.HP, RAM.SIZE_12GB, CPU.INTEL, Color.GOLD, OS.WINDOWS, 
                Storage.SIZE_512GB, Performance_cores.PIECES6, 899990, 20);
        laptops.add(hpSpectre);

        Laptop lenovoThinkPad = new Laptop(Manufacturer.LENOVO, RAM.SIZE_32GB, CPU.INTEL, Color.BLACK, OS.WINDOWS, 
                Storage.SIZE_2000GB, Performance_cores.PIECES8, 1599980, 10);
        laptops.add(lenovoThinkPad);

        Laptop msiGamingLaptop = new Laptop(Manufacturer.MSI, RAM.SIZE_16GB, CPU.INTEL, Color.BLACK, OS.WINDOWS, 
                Storage.SIZE_1024GB, Performance_cores.PIECES6, 1899980, 5);
        laptops.add(msiGamingLaptop);

        Laptop appleMacBookAir = new Laptop(Manufacturer.APPLE, RAM.SIZE_8GB, CPU.APPLE, Color.SPACE_GRAY, OS.MACOS, 
                Storage.SIZE_256GB, Performance_cores.PIECES4, 1299890, 30);
        laptops.add(appleMacBookAir);

        Laptop acerPredator = new Laptop(Manufacturer.ACER, RAM.SIZE_32GB, CPU.INTEL, Color.BLACK, OS.WINDOWS,
                 Storage.SIZE_2000GB, Performance_cores.PIECES8, 2199990, 8);
        laptops.add(acerPredator);

        Laptop gigabyteAero = new Laptop(Manufacturer.GIGABYTE, RAM.SIZE_16GB, CPU.INTEL, Color.WHITE, OS.WINDOWS, 
                Storage.SIZE_512GB, Performance_cores.PIECES6, 1699990, 12);
        laptops.add(gigabyteAero);

        Laptop huaweiMateBook = new Laptop(Manufacturer.HUAWEI, RAM.SIZE_8GB, CPU.INTEL, Color.GRAY, OS.WINDOWS, 
                Storage.SIZE_512GB, Performance_cores.PIECES4, 1049980, 18);
        laptops.add(huaweiMateBook);

        Laptop xiaomiMiNotebook = new Laptop(Manufacturer.XIAOMI, RAM.SIZE_16GB, CPU.INTEL, Color.SPACE_GRAY, OS.WINDOWS, 
                Storage.SIZE_512GB, Performance_cores.PIECES8, 1299980, 22);
        laptops.add(xiaomiMiNotebook);

        int userAction;

        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести все ноутбуки");
            System.out.println("2. Вывести параметры фильтрации");
            System.out.println("3. Выход из программы");
            try {
                userAction = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректное число!");
                scanner.nextLine();
                userAction = 0;
            }

            switch (userAction) {
                case SHOW_ALL_LAPTOPS:
                    System.out.println(laptops);
                    break;
                case SHOW_FILTER_OPTIONS:
                    HashMap<String, String> filter = getFilters();
                    HashSet<Laptop> filteredLaptops = getFilteredLaptops(filter, laptops);

                    if (filteredLaptops.isEmpty()) {
                        System.out.println("Нет ноутбуков, соответствующих вашему критерию");
                    } else if (filteredLaptops.size() > 1) {
                        System.out.println(filteredLaptops);

                        System.out.println("Хотите ли вы купить ноутбук из предложенных?\n1 - Да\n2 - Нет");
                        int answer;
                        try {
                            answer = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Ошибка: Введите корректное число!");
                            scanner.nextLine();
                            break;
                        }

                        if (answer == 1) {
                            System.out.println("Введите \"ДА\" на нужном варианте и \"НЕТ\", если этот ноутбук не нужен");
                            System.out.println("После ввода \"НЕТ\" нажмите ENTER/RETURN");
                            Iterator<Laptop> iterator = filteredLaptops.iterator();
                            int count = 1;
                            while (iterator.hasNext()) {
                                Laptop element = iterator.next();
                                String laptopVariant = String.format("%d - %s", count++, element);
                                System.out.println("Купить этот вариант?\n" + laptopVariant);
                                scanner.nextLine();
                                String variantAnswer = scanner.nextLine();
                                if (variantAnswer.toUpperCase().equals("ДА")) {
                                    try {
                                        scanner.nextLine();
                                        buyLaptop(element);
                                    } catch (IllegalArgumentException ex) {
                                        System.out.println("Ошибка: " + ex.getMessage());
                                    }
                                    break;
                                } else if (variantAnswer.toUpperCase().equals("НЕТ")) {
                                    
                                }
                            }
                        }
                    } else {
                        Iterator<Laptop> iterator = filteredLaptops.iterator();
                        Laptop element = iterator.next();
                        System.out.println(element);
                        System.out.println("Хотите ли вы купить ноутбук из предложенных?\n1 - Да\n2 - Нет");
                        int answer;
                        try {
                            answer = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Ошибка: Введите корректное число!");
                            scanner.nextLine();
                            break;
                        }

                        if (answer == 1) {
                            buyLaptop(element);
                        }
                    }

                    break;
                case EXIT_PROGRAM:
                    scanner.close();
                    break;
                default:
                    break;
            }
        } while (userAction != EXIT_PROGRAM);
    }
}
