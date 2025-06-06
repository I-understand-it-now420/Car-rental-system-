import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer in the rental system.
 */
public class Customer {
    private String name;
    private String id;
    private List<Car> rentalHistory;

    /**
     * Constructor to initialize a Customer object.
     */
    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
        this.rentalHistory = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Car> getRentalHistory() {
        return rentalHistory;
    }

    /**
     * Adds a rented car to the customer's rental history.
     */
    public void addRental(Car car) {
        rentalHistory.add(car);
    }
}
