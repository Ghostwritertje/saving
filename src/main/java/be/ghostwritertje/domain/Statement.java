package be.ghostwritertje.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Entity
@Table(name = "T_STATEMENT")
public class Statement extends DomainObject {

    @ManyToOne
    @JoinColumn(name = "originatingAccount_id")
    private BankAccount originatingAccount;
    @ManyToOne
    @JoinColumn(name = "destinationAccount_id")
    private BankAccount destinationAccount;
    private LocalDate date;
    private Double amount;

    public BankAccount getOriginatingAccount() {
        return originatingAccount;
    }

    public void setOriginatingAccount(BankAccount originatingAccount) {
        this.originatingAccount = originatingAccount;
    }

    public BankAccount getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(BankAccount destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
