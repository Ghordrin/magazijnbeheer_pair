package com.syntra.tristanyannick.model.statuses;

import com.syntra.tristanyannick.model.products.Product;

public class Low extends Status {

    /**
     * Low state of a product. If product reaches this state the stock needs to be refilled ASAP.
     */
    public Low() {
        statusDescription = StatusDescription.LOW;
    }

    /**
     * Sells a new {@link Product} based on the specified amount.
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */
    @Override
    public void sell(Product product, int amount) {
        outWarning();
        super.sell(product, amount);
    }

    /**
     * Reloctes a new {@link Product} based on the specified amount. Relocation happens if stock is too high.
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */
    @Override
    public void relocate(Product product, int amount) {
        outWarning();
        super.relocate(product, amount);
    }

    /**
     * Removes a new {@link Product} based on the specified amount. Removal happens when stock is too high.
     *
     * @param product Takes a {@link Product} object.
     * @param amount  Amount of products for stockmovement - varies on method.
     */
    @Override
    public void remove(Product product, int amount) {
        outWarning();
        super.remove(product, amount);
    }

    /**
     * Prints out a warning to let user know a movement was not executed properly.
     */
    private void outWarning() {
        System.out.println("-----> Status: " + statusDescription.toString() + "! Need to produce/buy soon! <-----");
    }
}
