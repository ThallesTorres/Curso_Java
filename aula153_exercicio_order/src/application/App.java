package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("--Enter client data-- ");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        // String birthDate = sc.next();
        LocalDate birDate = LocalDate.parse(sc.next(), dateFormatter);

        Client client = new Client(name, email, birDate);

        System.out.println("\n--Enter order data--");
        System.out.print("Status (PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED): ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        System.out.print("How many items to this order? ");
        int temp = sc.nextInt();

        Order order = new Order(LocalDateTime.now(), status, client);

        for (int i = 1; i <= temp; i++) {
            System.out.printf("\n-Enter #%d item data-\n", i);
            System.out.print("Product name: ");
            String tName = sc.next();
            System.out.print("Product price: ");
            Double tPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int tQuantity = sc.nextInt();
            
            Product product = new Product(tName, tPrice);
            OrderItem item = new OrderItem(tQuantity, tPrice, product);

            order.addItem(item);
        }

        System.out.println(order.toString());

        sc.close();
    }
}
