package Laptop_class;

enum Manufacturer {
    ACER,
    AORUS,
    APPLE,
    ASUS,
    DELL,
    GIGABYTE,
    HP,
    HUAWEI,
    LENOVO,
    MSI,
    XIAOMI
}

enum RAM {
    SIZE_4GB("4 GB"),
    SIZE_6GB("6 GB"),
    SIZE_8GB("8 GB"),
    SIZE_12GB("12 GB"),
    SIZE_16GB("16 GB"),
    SIZE_32GB("32 GB");

    private final String sizeLabel;

    RAM(String sizeLabel) {
        this.sizeLabel = sizeLabel;
    }

    public String getSizeLabel() {
        return sizeLabel;
    }
}

enum CPU {
    INTEL,
    AMD,
    APPLE
}

enum Storage {
    SIZE_128GB("128 GB"),
    SIZE_256GB("256 GB"),
    SIZE_500GB("500 GB"),
    SIZE_512GB("512 GB"),
    SIZE_1000GB("1000 GB"),
    SIZE_1024GB("1024 GB"),
    SIZE_2000GB("2000 GB");

    private final String sizeLabel;

    Storage(String sizeLabel) {
        this.sizeLabel = sizeLabel;
    }

    public String getSizeLabel() {
        return sizeLabel;
    }
}

enum OS {
    WINDOWS,
    LINUX,
    MACOS
}

enum Performance_cores {
    PIECES2(2),
    PIECES4(4),
    PIECES6(6),
    PIECES8(8);

    private final int amount;

    Performance_cores(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

enum Color {
    BLACK,
    SPACE_GRAY,
    GRAY,
    WHITE,
    PINK,
    GOLD
}