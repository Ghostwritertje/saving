package be.ghostwritertje.domain.investing;

import be.ghostwritertje.domain.DomainObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 10-Oct-16.
 */
@Entity
@Table(name = "T_STOCK")
public class Stock extends DomainObject {
    @Column(unique = true)
    private String quote;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "stock")
    private List<HistoricPrice> historicPriceList;

    public Stock() {
    }

    public Stock(String quote) {
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public List<HistoricPrice> getHistoricPriceList() {
        if (this.historicPriceList == null) {
            this.historicPriceList = new ArrayList<>();
        }
        return historicPriceList;
    }

    public void setHistoricPriceList(List<HistoricPrice> historicPriceList) {
        this.historicPriceList = historicPriceList;
    }
}
