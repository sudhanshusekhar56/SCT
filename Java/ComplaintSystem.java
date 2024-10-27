// stataic sized array
//arrayList to be done later

import java.util.Scanner;

public class ComplaintSystem {
    private static final int MAX_COMPLAINTS = 100;
    private static Complaint[] complaints = new Complaint[MAX_COMPLAINTS];
    private static int complaintCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register Complaint");
            System.out.println("2. Delete Complaint");
            System.out.println("3. Display All Complaints");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    registerComplaint();
                    break;
                case 2:
                    deleteComplaint();
                    break;
                case 3:
                    displayAllComplaints();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerComplaint() {
        if (complaintCount >= MAX_COMPLAINTS) {
            System.out.println("Complaint list is full. Cannot register more complaints.");
            return;
        }

        System.out.print("Enter Complaint Type: ");
        String complaintType = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter LandMark: ");
        String landmark = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Problem: ");
        String problem = scanner.nextLine();
        System.out.print("Enter Consumer Number: ");
        int consumerNumber = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobileNumber = scanner.nextLine();

        complaints[complaintCount++] = new Complaint(complaintType, category, landmark, customerName, problem, consumerNumber, address, mobileNumber);
        System.out.println("Successfully registered Complaint");
    }

    private static void deleteComplaint() {
        System.out.print("Enter Consumer Number of Complaint to delete: ");
        int consumerNumber = scanner.nextInt();

        for (int i = 0; i < complaintCount; i++) {
            if (complaints[i].getConsumerNumber() == consumerNumber) {
                complaints[i] = complaints[complaintCount - 1];  // Replace with the last complaint
                complaints[--complaintCount] = null;  // Nullify last element and reduce count
                System.out.println("Complaint details are deleted");
                return;
            }
        }
        System.out.println("Complaint not found.");
    }

    private static void displayAllComplaints() {
        if (complaintCount == 0) {
            System.out.println("No complaints registered.");
            return;
        }

        for (int i = 0; i < complaintCount; i++) {
            System.out.println(complaints[i]);
        }
    }
}

class Complaint {
    private String complaintType;
    private String category;
    private String landmark;
    private String customerName;
    private String problem;
    private int consumerNumber;
    private String address;
    private String mobileNumber;

    public Complaint(String complaintType, String category, String landmark, String customerName,
                     String problem, int consumerNumber, String address, String mobileNumber) {
        this.complaintType = complaintType;
        this.category = category;
        this.landmark = landmark;
        this.customerName = customerName;
        this.problem = problem;
        this.consumerNumber = consumerNumber;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    public int getConsumerNumber() {
        return consumerNumber;
    }

    @Override
    public String toString() {
        return "Complaint Type: " + complaintType + ", Category: " + category + ", Landmark: " + landmark +
               ", Customer Name: " + customerName + ", Problem: " + problem + ", Consumer Number: " + consumerNumber +
               ", Address: " + address + ", Mobile Number: " + mobileNumber;
    }
}
