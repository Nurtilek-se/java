import java.util.*;

// Базовый класс для транспортных средств
abstract class Vehicle {
    private String model;
    private String type;
    private double pricePerDay;

    public Vehicle(String model, String type, double pricePerDay) {
        this.model = model;
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public abstract String getVehicleDetails();

    @Override
    public String toString() {
        return "Транспорт: " + model + ", Тип: " + type + ", Цена/день: " + pricePerDay + "₸";
    }
}

// Класс для легковых автомобилей
class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String model, double pricePerDay, int seatingCapacity) {
        super(model, "Car", pricePerDay);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String getVehicleDetails() {
        return "Легковой автомобиль с вместимостью: " + seatingCapacity + " мест.";
    }
}

// Класс для грузовиков
class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String model, double pricePerDay, double loadCapacity) {
        super(model, "Truck", pricePerDay);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getVehicleDetails() {
        return "Грузовик с грузоподъемностью: " + loadCapacity + " тонн.";
    }
}

// Основной класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Список доступных транспортных средств
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota Camry", 16000.0, 5));
        vehicles.add(new Car("BMW X5", 28000.0, 5));
        vehicles.add(new Truck("Volvo FH", 40000.0, 20));
        vehicles.add(new Car("Hyundai Sonata", 14000.0, 5));
        vehicles.add(new Car("Mercedes-Benz C-Class", 30000.0, 5));
        vehicles.add(new Car("Kia Sportage", 18000.0, 5));
        vehicles.add(new Car("Honda CR-V", 20000.0, 5));
        vehicles.add(new Truck("MAN TGX", 45000.0, 25));

        // Отображение списка транспорта
        System.out.println("Доступные транспортные средства:");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i));
        }

        // Выбор транспортного средства
        System.out.print("\nВведите номер транспортного средства, которое хотите арендовать: ");
        int vehicleChoice = scanner.nextInt();
        if (vehicleChoice < 1 || vehicleChoice > vehicles.size()) {
            System.out.println("Некорректный выбор. Программа завершена.");
            return;
        }

        Vehicle selectedVehicle = vehicles.get(vehicleChoice - 1);

        // Указание количества дней аренды
        System.out.print("Введите количество дней аренды: ");
        int rentalDays = scanner.nextInt();
        if (rentalDays <= 0) {
            System.out.println("Некорректное количество дней. Программа завершена.");
            return;
        }

        // Расчёт общей стоимости
        double totalCost = selectedVehicle.getPricePerDay() * rentalDays;

        // Вывод итоговой информации
        System.out.println("\nВы выбрали: " + selectedVehicle);
        System.out.println("Количество дней: " + rentalDays);
        System.out.println("Общая стоимость аренды: " + totalCost + "₸");
    }
}
