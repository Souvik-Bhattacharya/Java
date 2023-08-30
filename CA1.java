class Smartphone {
    String brand;   // instance variable
    String model;  // instance variable

    // Constructor
    Smartphone(String brand, String model) {
        this.brand = brand; //assigning local variable value to the instance variable
        this.model = model; //assigning local variable value to the instance variable
    }

    // Instance method
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}

public class CA1 {
    public static void main(String[] args) {
        // Instantiating objects
        Smartphone Smartphone1 = new Smartphone("Samsung", "A50S");
        Smartphone Smartphone2 = new Smartphone("Motorola", "edge40");

        // Accessing instance variables and calling instance method
        Smartphone1.displayInfo();
        System.out.println();
        Smartphone2.displayInfo();
    }
}
