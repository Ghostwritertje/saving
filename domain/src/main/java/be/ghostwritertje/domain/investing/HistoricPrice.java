package be.ghostwritertje.domain.investing;

import be.ghostwritertje.domain.DomainObject;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by Jorandeboever
 * Date: 14-Oct-16.
 */
@Entity
@Table(name = "T_HISTORICPRICE")
public class HistoricPrice extends DomainObject {
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
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
