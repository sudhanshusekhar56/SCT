//using array

import java.util.Scanner;

public class BillingSystem {
    private static final int MAX_BILLS = 100;
    private static Bill[] bills = new Bill[MAX_BILLS];
    private static int billCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Bill");
            System.out.println("2. Update Amount Details");
            System.out.println("3. Delete Bill Details");
            System.out.println("4. Display All Bills");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBill();
                    break;
                case 2:
                    updateBillAmount();
                    break;
                case 3:
                    deleteBill();
                    break;
                case 4:
                    displayAllBills();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBill() {
        if (billCount >= MAX_BILLS) {
            System.out.println("Bill list is full. Cannot add more bills.");
            return;
        }

        System.out.print("Enter Consumer Number: ");
        int consumerNumber = scanner.nextInt();
        System.out.print("Enter Due Amount: ");
        double dueAmount = scanner.nextDouble();
        System.out.print("Enter Payable Amount: ");
        double payableAmount = scanner.nextDouble();

        bills[billCount++] = new Bill(consumerNumber, dueAmount, payableAmount);
        System.out.println("Bill details are added successfully");
    }

    private static void updateBillAmount() {
        System.out.print("Enter Consumer Number to update: ");
        int consumerNumber = scanner.nextInt();
        System.out.print("Enter new Due Amount: ");
        double newDueAmount = scanner.nextDouble();
        System.out.print("Enter new Payable Amount: ");
        double newPayableAmount = scanner.nextDouble();

        for (int i = 0; i < billCount; i++) {
            if (bills[i].getConsumerNumber() == consumerNumber) {
                bills[i].setDueAmount(newDueAmount);
                bills[i].setPayableAmount(newPayableAmount);
                System.out.println("Bill details are updated successfully");
                return;
            }
        }
        System.out.println("Bill not found.");
    }

    private static void deleteBill() {
        System.out.print("Enter Consumer Number to delete: ");
        int consumerNumber = scanner.nextInt();

        for (int i = 0; i < billCount; i++) {
            if (bills[i].getConsumerNumber() == consumerNumber) {
                bills[i] = bills[billCount - 1]; 
                bills[--billCount] = null; //makes the bull null and reduce the value of billCount
                System.out.println("Bill details are deleted");
                return;
            }
        }
        System.out.println("Bill not found.");
    }

    private static void displayAllBills() {
        if (billCount == 0) {
            System.out.println("No bills available.");
            return;
        }

        for (int i = 0; i < billCount; i++) {
            System.out.println(bills[i]);
        }
    }
}

class Bill {
    private int consumerNumber;
    private double dueAmount;
    private double payableAmount;

    public Bill(int consumerNumber, double dueAmount, double payableAmount) {
        this.consumerNumber = consumerNumber;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    public int getConsumerNumber() {
        return consumerNumber;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    @Override
    public String toString() {
        return "Consumer Number: " + consumerNumber + ", Due Amount: " + dueAmount + ", Payable Amount: " + payableAmount;
    }
}
