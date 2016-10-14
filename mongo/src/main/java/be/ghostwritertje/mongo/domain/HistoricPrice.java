package be.ghostwritertje.mongo.domain;

import java.time.LocalDate;

/**
 * Created by Jorandeboever
 * Date: 14-Oct-16.
 */
public class HistoricPrice {
    private LocalDate date;
    private Double price;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
