package be.ghostwritertje.mongo;

import org.springframework.data.annotation.Id;

/**
 * Created by Jorandeboever
 * Date: 10-Oct-16.
 */
public class Stock {
    @Id
    private String id;

    private String quote;
    private Double currentValue;

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
