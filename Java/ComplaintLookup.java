import java.util.Scanner;

public class ComplaintLookup {
    private static final int MAX_COMPLAINTS = 5; 
    private static Complaint[] complaints = new Complaint[MAX_COMPLAINTS];

    public static void main(String[] args) {
        complaints[0] = new Complaint(1234, "Alice Johnson", "Service", "Delivery Issue", "Delayed delivery of order", "9876543210", "Open");
        complaints[1] = new Complaint(5678, "Bob Smith", "Billing", "Incorrect Charge", "Charged for a service not used", "9123456789", "Closed");
        complaints[2] = new Complaint(9012, "Carol White", "Technical", "App Bug", "App crashes on login", "9345678123", "Open");
        complaints[3] = new Complaint(3456, "David Brown", "Service", "Quality Issue", "Product received was damaged", "9234567890", "Open");
        complaints[4] = new Complaint(7890, "Eve Black", "General", "Feedback", "Suggestion for new features", "9456781234", "Closed");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Consumer ID to view complaint details: ");
        int consumerId = scanner.nextInt();

        displayComplaintDetails(consumerId);
    }

    private static void displayComplaintDetails(int consumerId) {
        boolean found = false;

        System.out.printf("%-15s%-20s%-20s%-20s%-30s%-15s%-10s\n", "Consumer ID", "Customer Name", "Complaint Type", "Category", "Problem Description", "Mobile", "Status");

        for (Complaint complaint : complaints) {
            if (complaint != null && complaint.getConsumerId() == consumerId) {
                System.out.printf("%-15d%-20s%-20s%-20s%-30s%-15s%-10s\n", complaint.getConsumerId(), complaint.getCustomerName(),
                        complaint.getComplaintType(), complaint.getCategory(), complaint.getProblemDescription(),
                        complaint.getMobile(), complaint.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No complaints found for Consumer ID: " + consumerId);
        }
    }
}

class Complaint {
    private int consumerId;
    private String customerName;
    private String complaintType;
    private String category;
    private String problemDescription;
    private String mobile;
    private String status;

    public Complaint(int consumerId, String customerName, String complaintType, String category, String problemDescription, String mobile, String status) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.complaintType = complaintType;
        this.category = category;
        this.problemDescription = problemDescription;
        this.mobile = mobile;
        this.status = status;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public String getCategory() {
        return category;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public String getMobile() {
        return mobile;
    }

    public String getStatus() {
        return status;
    }
}
