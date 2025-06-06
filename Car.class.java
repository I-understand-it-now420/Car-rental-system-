/**
 * Represents a car in the rental system.
 */
public class Car {
    private String make;
    private String model;
    private int year;
    private boolean isRented;

    /**
     * Constructor to initialize a Car object.
     */
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isRented = false; // Initially, the car is not rented
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isRented() {
        return isRented;
    }

    /**
     * Marks the car as rented.
     */
    public void rent() {
        isRented = true;
    }

    /**
     * Marks the car as returned (available).
     */
    public void returnCar() {
        isRented = false;
    }
}
