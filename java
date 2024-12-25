// Класс для описания транспортного средства
class Vehicle {
    private String model;
    private String type;
    private double pricePerDay;
    // Конструктор
    public Vehicle(String model, String type, double pricePerDay) {
        this.model = model;
        this.type = type;
        this.pricePerDay = pricePerDay;
    }
    // Геттеры и сеттеры
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    // Метод для вывода информации о транспортном средстве
    @Override
    public String toString() {
        return "Vehicle: " + model + ", Type: " + type + ", Price/Day: $" + pricePerDay;
    }
}
// Класс для описания клиента
class Client {
    private String name;
    private String phone;
    // Конструктор
    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    // Геттеры и сеттеры
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Client: " + name + ", Phone: " + phone;
    }
}
// Класс для управления сервисом аренды
class RentalService {
    private Vehicle vehicle;
    private Client client;
    private int rentalDays;
    // Конструктор
    public RentalService(Vehicle vehicle, Client client, int rentalDays) {
        this.vehicle = vehicle;
        this.client = client;
        this.rentalDays = rentalDays;
    }
    // Метод для расчета общей стоимости аренды
    public double calculateTotalCost() {
        return vehicle.getPricePerDay() * rentalDays;
    }
    @Override
    public String toString() {
        return client + "\n" + vehicle + "\nRental Days: " + rentalDays + ", Total Cost: $" + calculateTotalCost();
    }
}
// Главный класс с методом main
public class Main {
    public static void main(String[] args) {
        // Создаем объекты
        Vehicle vehicle1 = new Vehicle("Toyota Camry", "Sedan", 40.0);
        Vehicle vehicle2 = new Vehicle("BMW M8", "Sedan", 60.0);
        Client client1 = new Client("Alice Johnson", "8-705-576-2132");
        Client client2 = new Client("Bob Smith", "8-771-321-0123");
        // Создаем аренду
        RentalService rental1 = new RentalService(vehicle1, client1, 3);
        RentalService rental2 = new RentalService(vehicle2, client2, 5);

        // Вывод информации на консоль
        System.out.println(rental1);
        System.out.println();
        System.out.println(rental2);

        // Сравнение стоимости аренды
        if (rental1.calculateTotalCost() > rental2.calculateTotalCost()) {
            System.out.println("\nRental 1 is more expensive.");
        } else {
            System.out.println("\nRental 2 is more expensive.");
        }
    }
}
