package workbook6.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class BedFrameStreamExplorer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Our product database
        // Each product is represented by a Map.
        // No separate Product class is needed.

        List<Map<String, Object>> products = new ArrayList<>();

        products.add(createProduct("Nordic Dream", "Wood", "King", 899.99, 5, 4.8));
        products.add(createProduct("Urban Comfort", "Metal", "Queen", 499.99, 12, 4.2));
        products.add(createProduct("Royal Velvet", "Fabric", "King", 1299.99, 3, 4.9));
        products.add(createProduct("Minimal Oak", "Wood", "Double", 699.99, 8, 4.5));
        products.add(createProduct("Industrial Steel", "Metal", "Single", 349.99, 15, 4.0));
        products.add(createProduct("Cloud Nine", "Fabric", "Queen", 1099.99, 0, 4.7));
        products.add(createProduct("Classic Pine", "Wood", "Single", 299.99, 20, 3.9));
        products.add(createProduct("Luxury Comfort", "Fabric", "King", 1599.99, 2, 5.0));
        products.add(createProduct("Modern Edge", "Metal", "Double", 599.99, 7, 4.3));
        products.add(createProduct("Scandinavian Style", "Wood", "Queen", 799.99, 6, 4.6));

        boolean running = true;

        while (running) {

            System.out.println("\n==================================");
            System.out.println("       BEDFRAME STREAM EXPLORER");
            System.out.println("==================================");

            System.out.println("1. Filter products in stock");
            System.out.println("2. Get all product names");
            System.out.println("3. Sort products by price");
            System.out.println("4. Count products made of wood");
            System.out.println("5. Find the cheapest bed frame");
            System.out.println("6. Find the highest-rated product");
            System.out.println("7. Calculate the average price");
            System.out.println("8. Group products by material");
            System.out.println("9. Partition products by availability");
            System.out.println("10. Calculate total inventory value");
            System.out.println("0. Exit");

            System.out.print("\nChoose an example: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.println("\n--- FILTER: Products in stock ---");

                    products.stream()
                            .filter(p -> (int) p.get("stock") > 0)
                            .forEach(BedFrameStreamExplorer::printProduct);
                }

                case 2 -> {
                    System.out.println("\n--- MAP: Product names ---");

                    products.stream()
                            .map(p -> p.get("name"))
                            .forEach(System.out::println);
                }

                case 3 -> {
                    System.out.println("\n--- SORTED: Products by price ---");

                    products.stream()
                            .sorted(Comparator.comparingDouble(
                                    p -> (double) p.get("price")))
                            .forEach(BedFrameStreamExplorer::printProduct);
                }

                case 4 -> {
                    System.out.println("\n--- COUNT: Wood products ---");

                    long count = products.stream()
                            .filter(p -> p.get("material").equals("Wood"))
                            .count();

                    System.out.println("Wood products: " + count);
                }

                case 5 -> {
                    System.out.println("\n--- MIN: Cheapest bed frame ---");

                    products.stream()
                            .min(Comparator.comparingDouble(
                                    p -> (double) p.get("price")))
                            .ifPresent(BedFrameStreamExplorer::printProduct);
                }

                case 6 -> {
                    System.out.println("\n--- MAX: Highest-rated product ---");

                    products.stream()
                            .max(Comparator.comparingDouble(
                                    p -> (double) p.get("rating")))
                            .ifPresent(BedFrameStreamExplorer::printProduct);
                }

                case 7 -> {
                    System.out.println("\n--- AVERAGE: Average product price ---");

                    double average = products.stream()
                            .mapToDouble(p -> (double) p.get("price"))
                            .average()
                            .orElse(0.0);

                    System.out.printf("Average price: $%.2f%n", average);
                }

                case 8 -> {
                    System.out.println("\n--- GROUPING: Products by material ---");

                    Map<Object, List<Map<String, Object>>> groupedProducts =
                            products.stream()
                                    .collect(Collectors.groupingBy(
                                            p -> p.get("material")));

                    groupedProducts.forEach((material, productList) -> {

                        System.out.println("\n" + material + ":");

                        productList.forEach(
                                BedFrameStreamExplorer::printProduct);
                    });
                }

                case 9 -> {
                    System.out.println("\n--- PARTITIONING: Product availability ---");

                    Map<Boolean, List<Map<String, Object>>> partitioned =
                            products.stream()
                                    .collect(Collectors.partitioningBy(
                                            p -> (int) p.get("stock") > 0));

                    System.out.println("\nAvailable products:");

                    partitioned.get(true).forEach(
                            BedFrameStreamExplorer::printProduct);

                    System.out.println("\nOut of stock:");

                    partitioned.get(false).forEach(
                            BedFrameStreamExplorer::printProduct);
                }

                case 10 -> {
                    System.out.println("\n--- REDUCE: Total inventory value ---");

                    double totalValue = products.stream()
                            .mapToDouble(p ->
                                    (double) p.get("price") *
                                            (int) p.get("stock"))
                            .reduce(0.0, Double::sum);

                    System.out.printf(
                            "Total inventory value: $%.2f%n", totalValue);
                }

                case 0 -> {
                    System.out.println("\nThanks for exploring Java Streams!");
                    running = false;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Helper method to create a product
    private static Map<String, Object> createProduct(
            String name,
            String material,
            String size,
            double price,
            int stock,
            double rating) {

        Map<String, Object> product = new HashMap<>();

        product.put("name", name);
        product.put("material", material);
        product.put("size", size);
        product.put("price", price);
        product.put("stock", stock);
        product.put("rating", rating);

        return product;
    }

    // Helper method to display a product
    private static void printProduct(Map<String, Object> product) {

        System.out.printf(
                "%-22s | %-7s | %-7s | $%8.2f | Stock: %2d | Rating: %.1f%n",
                product.get("name"),
                product.get("material"),
                product.get("size"),
                product.get("price"),
                product.get("stock"),
                product.get("rating")
        );
    }
}


