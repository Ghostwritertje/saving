package be.ghostwritertje.wicket.investing;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.domain.investing.FundPurchase;
import be.ghostwritertje.services.investing.FundPurchaseService;
import be.ghostwritertje.wicket.BasePage;
import be.ghostwritertje.wicket.CustomSession;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.time.LocalDate;

/**
 * Created by Jorandeboever
 * Date: 08-Oct-16.
 */
public class FundPurchaseListPage extends BasePage<Person> {
    @SpringBean
    private FundPurchaseService fundPurchaseService;

    public FundPurchaseListPage() {
        super(new Model<>(CustomSession.get().getLoggedInPerson()));
    }

    public FundPurchaseListPage(IModel<Person> model) {
        super(model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new ListView<FundPurchase>("fundPurchases", this.fundPurchaseService.findByOwner(this.getModelObject())) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                this.setViewSize(25);
            }

            @Override
            protected void populateItem(ListItem<FundPurchase> item) {
                item.add(new Label("date", item.getModelObject().getDate()));
                item.add(new Label("quote", item.getModelObject().getQuote()));
                item.add(new Label("count", item.getModelObject().getNumberOfShares()));
                item.add(new Label("sharePrice", item.getModelObject().getSharePrice()));
                item.add(new Label("transactionCost", item.getModelObject().getTransactionCost()));
                item.add(new Link<FundPurchase>("edit", item.getModel()) {
                    @Override
                    public void onClick() {
                        this.setResponsePage(new FundPurchasePage(this.getModel()));
                    }
                });
                item.add(new Link<FundPurchase>("delete", item.getModel()) {
                    @Override
                    public void onClick() {
                        FundPurchaseListPage.this.fundPurchaseService.delete(this.getModelObject());
                        this.setResponsePage(new FundPurchaseListPage(FundPurchaseListPage.this.getModel()));
                    }
                });
            }
        });

        this.add(new Link<FundPurchase>("newPurchaseLink") {
            @Override
            public void onClick() {
                FundPurchase fundPurchase = new FundPurchase();
                fundPurchase.setOwner(FundPurchaseListPage.this.getModelObject());
                fundPurchase.setDate(LocalDate.now());
                this.setResponsePage(new FundPurchasePage(new Model<FundPurchase>(fundPurchase)));
            }
        });
    }
}
