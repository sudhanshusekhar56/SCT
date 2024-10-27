//depicting the stored customer datail in array.
//the same is going to be stored when we add a new customer from our program

import java.util.Scanner;

public class CustomerLookup {
    private static final int MAX_CUSTOMERS = 5; // static array, we have used 100 in CustomerServiceSyatem, but here we are replicating only 5 for now
    private static Customer[] customers = new Customer[MAX_CUSTOMERS];

    public static void main(String[] args) {
        // Preconfigured customer data
        customers[0] = new Customer(1234, "Alice Johnson", "alice.j@example.com", "9876543210");
        customers[1] = new Customer(5678, "Bob Smith", "bob.s@example.com", "9123456789");
        customers[2] = new Customer(9012, "Carol White", "carol.w@example.com", "9345678123");
        customers[3] = new Customer(3456, "David Brown", "david.b@example.com", "9234567890");
        customers[4] = new Customer(7890, "Eve Black", "eve.b@example.com", "9456781234");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Consumer ID to view details: ");
        int consumerId = scanner.nextInt();

        displayCustomerDetails(consumerId);
    }

    private static void displayCustomerDetails(int consumerId) {
        boolean found = false;

        for (Customer customer : customers) {
            if (customer != null && customer.getConsumerId() == consumerId) {
                System.out.printf("%-15s%-20s%-15s%-20s\n", "Consumer ID", "Customer Name", "Mobile Number", "Email");
                System.out.printf("%-15d%-20s%-15s%-20s\n", customer.getConsumerId(), customer.getCustomerName(),
                        customer.getMobileNumber(), customer.getEmail());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No customer found with Consumer ID: " + consumerId);
        }
    }
}

class Customer {
    private int consumerId;
    private String customerName;
    private String email;
    private String mobileNumber;

    public Customer(int consumerId, String customerName, String email, String mobileNumber) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
