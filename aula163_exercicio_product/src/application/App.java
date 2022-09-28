package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int x = sc.nextInt();

        for (int i = 1; i <= x; i++) {
            System.out.print("\nCommon, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            switch (ch) {
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate manufactureDate = LocalDate.parse(sc.next(), dateFormatter);
                    products.add(new UsedProduct(name, price, manufactureDate));
                    break;

                case 'i':
                    System.out.print("Customs fee: ");
                    Double customsFee = sc.nextDouble();
                    products.add(new ImportedProduct(name, price, customsFee));
                    break;
            
                default:
                    products.add(new Product(name, price));
                    break;
            }
        }
        System.out.println("\n--PRICE TAGS--");

        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
