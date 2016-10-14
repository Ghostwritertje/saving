package be.ghostwritertje.domain.investing;

import be.ghostwritertje.domain.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jorandeboever
 * Date: 10-Oct-16.
 */
@Entity
@Table(name = "T_STOCK")
public class Stock extends DomainObject {
    private String quote;
    private Double currentValue;

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
