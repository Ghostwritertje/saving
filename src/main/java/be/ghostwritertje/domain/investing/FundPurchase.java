package be.ghostwritertje.domain.investing;

import be.ghostwritertje.domain.DomainObject;
import be.ghostwritertje.domain.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by Jorandeboever
 * Date: 08-Oct-16.
 */
@Table(name = "T_FUND_PURCHASE")
@Entity
public class FundPurchase extends DomainObject {
    private String quote;

    @Column(nullable = false)
    private Integer numberOfShares;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double sharePrice;

    @Column
    private Double transactionCost;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }


    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTransactionCost() {
        return transactionCost;
    }

    public void setTransactionCost(Double transactionCost) {
        this.transactionCost = transactionCost;
    }

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Double sharePrice) {
        this.sharePrice = sharePrice;
    }
}
