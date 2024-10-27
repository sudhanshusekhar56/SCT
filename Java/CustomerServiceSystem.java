// with static sized array

import java.util.Scanner;
import java.util.Random;

public class CustomerServiceSystem {
    private static final int MAX_CLIENTS = 100;
    private static Client[] clients = new Client[MAX_CLIENTS];
    private static int clientCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Client");
            System.out.println("2. Update Client");
            System.out.println("3. Delete Client");
            System.out.println("4. View All Clients");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    updateClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                    viewAllClients();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addClient() {
        if (clientCount >= MAX_CLIENTS) {
            System.out.println("Client list is full. Cannot add more clients.");
            return;
        }

        System.out.print("Enter Consumer ID: ");
        int consumerId = scanner.nextInt();
        System.out.print("Enter Bill Number: ");
        int billNumber = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Client Name: ");
        String clientName = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobileNumber = scanner.nextLine();
        String userId = generateUserId();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm Password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Client not added.");
            return;
        }

        clients[clientCount++] = new Client(consumerId, billNumber, title, clientName, email, mobileNumber, userId, password, confirmPassword);
        System.out.println("Client Registration is successful");
    }

    private static void updateClient() {
        System.out.print("Enter Consumer ID to update: ");
        int consumerId = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer
        System.out.print("Enter new Email: ");
        String newEmail = scanner.nextLine();

        for (int i = 0; i < clientCount; i++) {
            if (clients[i].consumerId == consumerId) {
                clients[i].email = newEmail;
                System.out.println("Client details are updated successfully");
                return;
            }
        }
        System.out.println("Client not found.");
    }

    private static void deleteClient() {
        System.out.print("Enter Consumer ID to delete: ");
        int consumerId = scanner.nextInt();

        for (int i = 0; i < clientCount; i++) {
            if (clients[i].consumerId == consumerId) {
                clients[i] = clients[clientCount - 1];  // Replace with the last client
                clients[--clientCount] = null;  // Nullify last element and reduce count
                System.out.println("Client details are deleted");
                return;
            }
        }
        System.out.println("Client not found.");
    }

    private static void viewAllClients() {
        if (clientCount == 0) {
            System.out.println("No clients available.");
            return;
        }

        for (int i = 0; i < clientCount; i++) {
            System.out.println(clients[i]);
        }
    }

    private static String generateUserId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder userId = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            userId.append(chars.charAt(random.nextInt(chars.length())));
        }
        return userId.toString();
    }
}

class Client {
    int consumerId;
    int billNumber;
    String title;
    String clientName;
    String email;
    String mobileNumber;
    String userId;
    String password;
    String confirmPassword;

    public Client(int consumerId, int billNumber, String title, String clientName, String email, String mobileNumber,
                  String userId, String password, String confirmPassword) {
        this.consumerId = consumerId;
        this.billNumber = billNumber;
        this.title = title;
        this.clientName = clientName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userId = userId;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "Consumer ID: " + consumerId + ", Bill Number: " + billNumber + ", Title: " + title + 
               ", Name: " + clientName + ", Email: " + email + ", Mobile: " + mobileNumber + ", User ID: " + userId;
    }
}
