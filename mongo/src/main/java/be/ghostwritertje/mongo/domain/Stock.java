package be.ghostwritertje.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 10-Oct-16.
 */
@CompoundIndexes({
        @CompoundIndex(name = "quote_index", def = "{'quote' : 1}", unique = true)
})
public class Stock {
    @Id
    private String id;
    private String quote;
    private Double currentValue;
    private List<HistoricPrice> historicPriceList;

    public List<HistoricPrice> getHistoricPriceList() {
        if (this.historicPriceList == null) {
            this.historicPriceList = new ArrayList<>();
        }
        return historicPriceList;
    }

    public void setHistoricPriceList(List<HistoricPrice> historicPriceList) {
        this.historicPriceList = historicPriceList;
    }

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
