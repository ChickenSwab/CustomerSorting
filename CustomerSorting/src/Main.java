import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static class Customer {
        private int id;
        private double balance;
        private String firstName;
        private String lastName;

        public Customer() {}

        public Customer(int id, double balance, String firstName, String lastName) {
            this.id = id;
            this.balance = balance;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return String.format("Customer[ID=%d, Name=%s %s, Balance=%.2f]",
                    id, firstName, lastName, balance);
        }
    }

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(101, 5000.00, "Alice", "Johnson"));
        customers.add(new Customer(102, 3000.00, "Bob", "Smith"));
        customers.add(new Customer(103, 4000.00, "Alice", "Anderson"));
        customers.add(new Customer(104, 7000.00, "Charlie", "Brown"));
        customers.add(new Customer(105, 4000.00, "Alice", "Johnson"));

        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                int firstNameComparison = c1.getFirstName().compareTo(c2.getFirstName());
                if (firstNameComparison != 0) return firstNameComparison;

                int lastNameComparison = c1.getLastName().compareTo(c2.getLastName());
                if (lastNameComparison != 0) return lastNameComparison;

                int idComparison = Integer.compare(c1.getId(), c2.getId());
                if (idComparison != 0) return idComparison;

                return Double.compare(c1.getBalance(), c2.getBalance());
            }
        });

        System.out.println("Sorted Customer List:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
