package com.syntra.tristanyannick.model.products;

public class Book extends Product {

    public Book(int amountLow, int amountHigh) {
        super(amountLow, amountHigh);
        this.name = "Book";
    }
}