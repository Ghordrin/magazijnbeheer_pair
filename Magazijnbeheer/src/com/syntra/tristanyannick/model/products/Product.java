package com.syntra.tristanyannick.model.products;

import com.syntra.tristanyannick.factories.ProductFactory;
import com.syntra.tristanyannick.model.statuses.Normal;
import com.syntra.tristanyannick.model.statuses.Status;
import com.syntra.tristanyannick.model.stock.Stock;
import com.syntra.tristanyannick.model.stock.StockMovement;

import java.util.LinkedList;

public abstract class Product implements Comparable<Product> {

    /**
     * Name of the product
     */
    protected String name;
    /**
     * A linkedlist of Stock
     */
    private LinkedList<Stock> stocks = new LinkedList<>();
    /**
     * Current state of product. On creation this is normal.
     */
    private Status status;
    /**
     * The initial stock. Generated on creation of Product.
     */
    private int initialStock;

    /**
     * Lowest level of stock of the product allowed. If level is lower then status becomes {@link com.syntra.tristanyannick.model.statuses.Critical}
     */
    public final int AMOUNT_LOW;
    /**
     * Highest level of stock of the product allowed
     */
    public final int AMOUNT_HIGH;
    /**
     * Critic level of stock of the product allowed.
     */
    public final int AMOUNT_CRITICAL;

    //Constructor

    /**
     * On creation of stock {@link Product#initialStock} and the {@link Status} of {@link Normal} are created.
     *
     * @param amountLow  Lowest amount of product allowed before it turns critical. Value generated automatically by {@link ProductFactory}
     * @param amountHigh Highest amount of product allowed before stock needs to be moved. Value generated automatically by {@link ProductFactory}.
     */
    public Product(int amountLow, int amountHigh) {
        AMOUNT_LOW = amountLow;
        AMOUNT_HIGH = amountHigh;
        AMOUNT_CRITICAL = AMOUNT_LOW / 2;
        initialStock = AMOUNT_LOW + 1 + (int) (Math.random() * (AMOUNT_HIGH - 1)); //A number between (and excluding) AMOUNT_LOW and AMOUNT_HIGH
        status = new Normal();
    }

    //Methods

    /**
     * Buys a product. See {@link Status#buy(Product, int)}
     *
     * @param amount Integer with the amount of products bought. See {@link Status#buy(Product, int)}
     */
    public void buy(int amount) {
        status.buy(this, amount);
    }

    /**
     * Produces a product. See {@link Status#produce(Product, int)}
     *
     * @param amount Integer with the amount of products produced. See {@link Status#produce(Product, int)}
     */
    public void produce(int amount) {
        status.produce(this, amount);
    }

    /**
     * Sells a product. See {@link Status#sell(Product, int)}
     *
     * @param amount Integer with the amount of products sold. See {@link Status#sell(Product, int)}
     */
    public void sell(int amount) {
        status.sell(this, amount);
    }

    /**
     * Removes a product from stock. See {@link Status#remove(Product, int)}
     *
     * @param amount Integer with the amount of products removed. See {@link Status#remove(Product, int)}
     */
    public void remove(int amount) {
        status.remove(this, amount);
    }

    /**
     * Relocates another product. See {@link Status#relocate(Product, int)}
     *
     * @param amount Integer with the amount of products relocated. See {@link Status#relocate(Product, int)}
     */
    public void relocate(int amount) {
        status.relocate(this, amount);
    }

    /**
     * Returns the current stock. Generates an initial stock by using {@link Product#initialStock}. Based on the input
     * of the stockmovement lower or higher the stock.
     *
     * @return an Integer with the current stock.
     */
    public int getCurrentStock() {
        int currentStock = initialStock;
        for (Stock stock : stocks) {
            if (stock.isHasHappened()) {
                if (stock.getStockMovement().equals(StockMovement.IN_BUY)
                        || stock.getStockMovement().equals(StockMovement.IN_PRODUCTION))
                    currentStock += stock.getAmount();
                else
                    currentStock -= stock.getAmount();
            }
        }
        return currentStock;
    }

    /**
     * Calculates the free space left per product.
     *
     * @return Integer with the amount of free space left
     */
    public int getFreeSpace() {
        return AMOUNT_HIGH - getCurrentStock();
    }

    /**
     * Adds stock to the product.
     *
     * @param stock {@link Stock}
     */
    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    /**
     * Sets the status of the product. Based on status action will or will not be taken.
     *
     * @param status Sets the {@link Status}
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Name of the product
     *
     * @return the namer of the product.
     */

    public String getName() {
        return name;
    }

    /**
     * Linked List with {@link Stock} objects
     *
     * @return a linked list.
     */
    public LinkedList<Stock> getStocks() {
        return stocks;
    }

    /**
     * Gets the current status of the product
     *
     * @return {@link Status}
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Get the initialStock generated. This is the stock generated when a product is first created.
     *
     * @return the initial stock
     */
    public int getInitialStock() {
        return initialStock;
    }

    //Overrides
    @Override
    public String toString() {
        String allStockValidations = "";
        for (Stock stock : stocks) {
            if (!allStockValidations.isEmpty())
                allStockValidations += "\n";
            allStockValidations += "\t\t";
            allStockValidations += stock.toString();
        }
        return name + ":\n" +
                "\tCritical: " + AMOUNT_CRITICAL + "; LOW: " + AMOUNT_LOW + "; HIGH: " + AMOUNT_HIGH + ";\n" +
                "\tCurrent stock: " + getCurrentStock() + "\n" +
                "\tStatus: " + status.toString() + "\n" +
                allStockValidations;
    }

    @Override
    public int compareTo(Product product) {
        return name.compareTo(product.getName());
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Product)
            return this.name.equals(((Product) object).getName());
        return false;
    }

}

