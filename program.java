import java.util.*;

class Ноутбук {
    private String бренд;
    private int озу;
    private int объемЖД;
    private String операционнаяСистема;
    private String цвет;

    // Конструктор
    public Ноутбук(String бренд, int озу, int объемЖД, String операционнаяСистема, String цвет) {
        this.бренд = бренд;
        this.озу = озу;
        this.объемЖД = объемЖД;
        this.операционнаяСистема = операционнаяСистема;
        this.цвет = цвет;
    }

    // Геттеры
    public String getБренд() {
        return бренд;
    }

    public int getОзу() {
        return озу;
    }

    public int getОбъемЖД() {
        return объемЖД;
    }

    public String getОперационнаяСистема() {
        return операционнаяСистема;
    }

    public String getЦвет() {
        return цвет;
    }

    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<Ноутбук> ноутбуки = new HashSet<>();
        ноутбуки.add(new Ноутбук("Lenovo", 8, 512, "Windows", "Черный"));
        ноутбуки.add(new Ноутбук("Apple", 16, 1024, "macOS", "Серебряный"));
        ноутбуки.add(new Ноутбук("HP", 12, 256, "Windows", "Белый"));

        // Запускаем фильтрацию
        фильтроватьНоутбуки(ноутбуки);
    }

    public static void фильтроватьНоутбуки(Set<Ноутбук> ноутбуки) {
        // Получаем данные от пользователя для фильтрации
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру критерия фильтрации: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        int критерий = scanner.nextInt();
        int минимальное_значение = 0;
        switch (критерий) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ: ");
                минимальное_значение = scanner.nextInt();
                for (Ноутбук н : ноутбуки) {
                    if (н.getОзу() >= минимальное_значение) {
                        System.out.println(н.getБренд());
                    }
                }
                break;
            case 2:
                System.out.println("Введите минимальное значение объема ЖД: ");
                минимальное_значение = scanner.nextInt();
                for (Ноутбук н : ноутбуки) {
                    if (н.getОбъемЖД() >= минимальное_значение) {
                        System.out.println(н.getБренд());
                    }
                }
                break;
            case 3:
                System.out.println("Введите операционную систему: ");
                String операционная_система = scanner.nextLine();
                scanner.nextLine(); // Очистка буфера
                for (Ноутбук н : ноутбуки) {
                    if (н.getОперационнаяСистема().equalsIgnoreCase(операционная_система.trim())) {
                        System.out.println(н.getБренд());
                    }
                }
                break;
            case 4:
                System.out.println("Введите цвет: ");
                String цвет = scanner.nextLine();
                scanner.nextLine(); // Очистка буфера
                for (Ноутбук н : ноутбуки) {
                    if (н.getЦвет().equalsIgnoreCase(цвет.trim())) {
                        System.out.println(н.getБренд());
                    }
                }
                break;
            default:
                System.out.println("Неверный критерий.");
        }
        scanner.close();
    }
}
