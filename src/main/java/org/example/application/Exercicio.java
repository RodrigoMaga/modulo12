package org.example.application;

import org.example.entitites.Client;
import org.example.entitites.Order;
import org.example.entitites.OrderItem;
import org.example.entitites.Product;
import org.example.entitites.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter client's data:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(scanner.next());
//        sdf.format(birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = scanner.next();
        System.out.print("How many items to this order? ");
        int quantity = scanner.nextInt();
        Date orderMoment = Date.from(Instant.now());

        Order order = new Order(orderMoment, OrderStatus.valueOf(status), new Client(name, email, birthDate));


        for (int i = 1; i <= quantity; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = scanner.next();
            System.out.print("Product price: ");
            Double productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = scanner.nextInt();

            OrderItem item = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
            order.addItem(item);
            item.subTotal();
        }

        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + sdf2.format(orderMoment));
        System.out.println("Order status: " + order.getStatus());
        System.out.println(order.getClient());
        System.out.println(order.getItems());

        System.out.printf("$ %.2f%n", order.total());




    }
}
