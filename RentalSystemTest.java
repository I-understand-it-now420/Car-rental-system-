/**
 * Test class to validate the functionality of the car rental system.
 */
public class RentalSystemTest {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        
        // Create cars
        Car car1 = new Car("Toyota", "Camry", 2020);
        Car car2 = new Car("Honda", "Civic", 2019);
        
        // Add cars to the agency
        agency.addCar(car1);
        agency.addCar(car2);
        
        // Create customers
        Customer customer1 = new Customer("John Doe", "C001");
        Customer customer2 = new Customer("Jane Smith", "C002");
        
        // Add customers to the agency
        agency.addCustomer(customer1);
        agency.addCustomer(customer2);
        
        // Test renting a car
        System.out.println("Renting car: " + agency.rentCar("C001", "Toyota", "Camry")); // Should return true
        System.out.println("Renting car again: " + agency.rentCar("C001", "Toyota", "Camry")); // Should return false
        
        // Test returning a car
        System.out.println("Returning car: " + agency.returnCar("C001", "Toyota", "Camry")); // Should return true
        System.out.println("Returning car again: " + agency.returnCar("C001", "Toyota", "Camry")); // Should return false
    }
}
