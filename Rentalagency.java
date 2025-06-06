import java.util.ArrayList;
import java.util.List;

/**
 * Manages the rental agency's cars and customers.
 */
public class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;

    /**
     * Constructor to initialize the RentalAgency.
     */
    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    /**
     * Adds a car to the agency's fleet.
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    /**
     * Adds a customer to the agency.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Rents a car to a customer if available.
     */
    public boolean rentCar(String customerId, String carMake, String carModel) {
        Customer customer = findCustomerById(customerId);
        Car car = findCar(carMake, carModel);

        if (customer != null && car != null && !car.isRented()) {
            car.rent();
            customer.addRental(car);
            return true;
        }
        return false;
    }

    /**
     * Returns a rented car.
     */
    public boolean returnCar(String customerId, String carMake, String carModel) {
        Customer customer = findCustomerById(customerId);
        Car car = findCar(carMake, carModel);

        if (customer != null && car != null && car.isRented()) {
            car.returnCar();
            return true;
        }
        return false;
    }

    private Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    private Car findCar(String make, String model) {
        for (Car car : cars) {
            if (car.getMake().equals(make) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }
}
