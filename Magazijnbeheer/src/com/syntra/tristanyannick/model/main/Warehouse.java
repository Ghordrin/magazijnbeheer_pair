package com.syntra.tristanyannick.model.main;

import com.syntra.tristanyannick.factories.ProductFactory;
import com.syntra.tristanyannick.factories.StockMovementFactory;
import com.syntra.tristanyannick.model.products.Product;
import com.syntra.tristanyannick.model.stock.StockMovement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.SortedSet;
import java.util.TreeSet;

public class Warehouse {

    /**
     * Minimum amount of products: 5
     */
    private static final int MIN_NUMBER_OF_PRODUCTS = 5;
    /**
     * Max amount of products: 11
     */
    private static final int MAX_NUMBER_OF_PRODUCTS = 11;
    /**
     * Min amount of stock movements
     */
    private static final int MIN_NUMBER_OF_STOCK_MOVEMENTS = 5;
    /**
     * Max amount of stock movements: 10
     */
    private static final int MAX_NUMBER_OF_STOCK_MOVEMENTS = 10;
    /**
     * Default file name for output = magazijn.txt
     */


    private static final File magazijnFile = new File("magazijn.txt");
    private static final LocalDateTime dt = LocalDateTime.now();
    private static final DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;

    /**
     * Main method writes directly to a log file. File location is set automatically to directory.
     *
     * @throws FileNotFoundException If file is not found an exception is thrown.
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream outputFile = new PrintStream(magazijnFile);
        System.out.println("Writing to file in filepath:" + magazijnFile.getAbsolutePath());
        System.setOut(outputFile);
        System.out.println("DATE OF MOVEMENT: " + df.format(dt));
        SortedSet<Product> products = instantiateProducts();
        generateAndPerformStockMovements(products);
        printProducts(products);
    }

    /**
     * Prints out the products to console
     *
     * @param products SortedSet of {@link Product} objects
     */
    private static void printProducts(SortedSet<Product> products) {
        for (Product product : products)
            System.out.println(product.toString());
    }

    /**
     * Generates and executes the stockmovement. The amount of movements created is random.
     *
     * @param products SortedSet of {@link Product} objects
     */
    public static void generateAndPerformStockMovements(SortedSet<Product> products) {
        StockMovementFactory stockMovementFactory = StockMovementFactory.getInstance();
        for (Product product : products) {
            System.out.println(product.toString());
            int numberOfStockMovements = MIN_NUMBER_OF_STOCK_MOVEMENTS + (int) (Math.random() * (MAX_NUMBER_OF_STOCK_MOVEMENTS - MIN_NUMBER_OF_STOCK_MOVEMENTS + 1));
            for (int i = 0; i < numberOfStockMovements; i++) {
                StockMovement stockMovement = stockMovementFactory.createRandomStockMovement();
                performStockMovement(product, stockMovement);
                System.out.println();
            }
            System.out.println();
            System.out.println("<><><>--------------------<><><>");
            System.out.println();
        }
    }

    /**
     * Helper method used for generation and execution of stock movements in method generateAndPerformStockMovements. The amount is randomly generated.
     *
     * @param product       Takes a {@link com.syntra.tristanyannick.model.products.Product} object
     * @param stockMovement Takes a {@link com.syntra.tristanyannick.model.stock.StockMovement} object
     */
    private static void performStockMovement(Product product, StockMovement stockMovement) {
        int amount = (int) (Math.random() * (product.AMOUNT_HIGH + 1));
        switch (stockMovement) {
            case IN_BUY:
                product.buy(amount);
                break;
            case IN_PRODUCTION:
                product.produce(amount);
                break;
            case OUT_SELL:
                product.sell(amount);
                break;
            case OUT_REMOVE:
                product.remove(amount);
                break;
            case OUT_RELOCATE:
                product.relocate(amount);
                break;
            default:
                break;
        }
    }

    /**
     * Create a set of ordered {@link Product}s. The amount of products generated is random.
     *
     * @return SortedSet of {@link Product} objects (sorted)
     */
    private static SortedSet<Product> instantiateProducts() {
        SortedSet<Product> products = new TreeSet<>();
        ProductFactory productFactory = ProductFactory.getInstance();
        int numberOfProducts = MIN_NUMBER_OF_PRODUCTS + (int) (Math.random() * (MAX_NUMBER_OF_PRODUCTS - MIN_NUMBER_OF_PRODUCTS + 1));
        while (products.size() < numberOfProducts) {
            products.add(productFactory.createRandomProduct());
        }
        return products;
    }

}
