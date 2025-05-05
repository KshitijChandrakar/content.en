class Vehicle {
    private String brand;
    private String model;
    private double price;

    public Vehicle(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}

class Car extends Vehicle {
    private int seatingCapacity;
    private String fuelType;

    public Car(String brand, String model, double price, int seatingCapacity, String fuelType) {
        super(brand, model, price);
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seating Capacity: " + seatingCapacity);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class ElectricCar extends Car {
    private double batteryCapacity;
    private double chargingTime;

    public ElectricCar(String brand, String model, double price, int seatingCapacity, String fuelType, double batteryCapacity, double chargingTime) {
        super(brand, model, price, seatingCapacity, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity);
        System.out.println("Charging Time: " + chargingTime);
    }
}

class Motorcycle extends Vehicle {
    private double engineCapacity;
    private String type;

    public Motorcycle(String brand, String model, double price, double engineCapacity, String type) {
        super(brand, model, price);
        this.engineCapacity = engineCapacity;
        this.type = type;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity);
        System.out.println("Type: " + type);
    }
}

public class VehicleManufacturing {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Generic", "V1", 10000);
        Car car = new Car("Toyota", "Corolla", 20000, 5, "Petrol");

        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 80000, 5, "Electric", 100, 10);

        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 15000, 1200, "Cruiser");

        System.out.println("Vehicle Details:");
        vehicle.displayDetails();
        System.out.println("-------------");

        System.out.println("Car Details:");
        car.displayDetails();
        System.out.println("-------------");

        System.out.println("Electric Car Details:");
        electricCar.displayDetails();
        System.out.println("-------------");

        System.out.println("Motorcycle Details:");
        motorcycle.displayDetails();
        System.out.println("-------------");
    }
}
