package com.syntra.tristanyannick.factories;

import com.syntra.tristanyannick.model.stock.StockMovement;

public class StockMovementFactory {

    /**
     * Returns a new instance of a stock movement factory. Using the Singleton principle.
     */
    private static StockMovementFactory instance = new StockMovementFactory();

    private StockMovementFactory() {
    }

    /**
     * Singleton instance for the stockmovement factory
     *
     * @return instance of StockmovementFactory
     */
    public static StockMovementFactory getInstance() {
        return instance;
    }

    /**
     * Adds all movements to an array and chooses whichever is chosen via parameter
     * <p>
     * - IN.BUY(0)
     * - IN.PRODUCE(1)
     * - OUT.SELL(2)
     * - OUT.RELOCATE(3)
     * = OUT.REMOVE(4)
     *
     * @param choice (Integer)
     * @return {@link StockMovement}
     */
    public StockMovement createStockMovement(int choice) {
        StockMovement[] stockMovements = StockMovement.values();
        return stockMovements[choice];
    }

    /**
     * Generate a random stockmovement based on an integer input.
     *
     * @return stockmovement enum (random)
     * @see StockMovementFactory#createStockMovement(int)
     */

    public StockMovement createRandomStockMovement() {
        int choice = (int) (Math.random() * StockMovement.values().length);
        return createStockMovement(choice);
    }
}
