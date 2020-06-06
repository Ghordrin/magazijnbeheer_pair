package com.syntra.tristanyannick.model.stock;

public enum StockMovement {

    IN_BUY("IN", "BUY"), IN_PRODUCTION("IN", "PRODUCE"),
    OUT_SELL("OUT", "SELL"), OUT_RELOCATE("OUT", "RELOCATE"), OUT_REMOVE("OUT", "REMOVE");

    private String direction;
    private String action;

    /**
     * The movement of the stock. Direction can be {@link StockMovement#IN_BUY}, {@link StockMovement#IN_PRODUCTION} or {@link StockMovement#OUT_SELL}, {@link StockMovement#OUT_RELOCATE or {@link StockMovement#OUT_REMOVE}}
     *
     * @param direction The direction. IN or OUT of stock.
     * @param action    The action of the direction. Buy, produce, sell, relocate or remove.
     */
    StockMovement(String direction, String action) {
        this.direction = direction;
        this.action = action;
    }

    /**
     * Get the current direction of the product
     *
     * @return {@link StockMovement#direction}
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Get the current action of the product.
     *
     * @return {@link StockMovement#action}
     */
    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return getDirection() + "." + getAction();
    }
}
