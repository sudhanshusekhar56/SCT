//depicting the stored bills datail in array.
//the same is going to be stored when we add a new bills from our program


import java.util.Scanner;

public class BillLookup {
    private static final int MAX_BILLS = 5;
    private static Bill[] bills = new Bill[MAX_BILLS];

    public static void main(String[] args) {
        //name, bill paid, dues
        bills[0] = new Bill(1234, "Alice Johnson", 100.50, 120.75);
        bills[1] = new Bill(5678, "Bob Smith", 0.0, 0.0);
        bills[2] = new Bill(9012, "Carol White", 200.00, 220.50);
        bills[3] = new Bill(3456, "David Brown", 0.0, 0.0);
        bills[4] = new Bill(7890, "Eve Black", 150.25, 175.00);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Consumer ID to view unpaid bill details: ");
        int consumerId = scanner.nextInt();

        displayUnpaidBillDetails(consumerId);
    }

    private static void displayUnpaidBillDetails(int consumerId) {
        boolean found = false;

        for (Bill bill : bills) {
            if (bill != null && bill.getConsumerId() == consumerId && bill.getDueAmount() > 0) {
                System.out.printf("%-15s%-20s%-15s%-20s\n", "Consumer ID", "Customer Name", "Due Amount", "Payable Amount");
                System.out.printf("%-15d%-20s%-15.2f%-20.2f\n", bill.getConsumerId(), bill.getCustomerName(),
                        bill.getDueAmount(), bill.getPayableAmount());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No unpaid bills found for Consumer ID: " + consumerId);
        }
    }
}

class Bill {
    private int consumerId;
    private String customerName;
    private double dueAmount;
    private double payableAmount;

    public Bill(int consumerId, String customerName, double dueAmount, double payableAmount) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public double getPayableAmount() {
        return payableAmount;
    }
}
