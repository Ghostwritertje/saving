package be.ghostwritertje.wicket.model;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.domain.budgetting.BankAccount;
import be.ghostwritertje.services.budgetting.BankAccountService;
import be.ghostwritertje.services.budgetting.StatementService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Jorandeboever
 * Date: 02-Oct-16.
 */
public class BankAccountListInfoPanel extends GenericPanel<Person> {
    @SpringBean
    private StatementService statementService;

    @SpringBean
    private BankAccountService bankAccountService;

    public BankAccountListInfoPanel(String id, IModel<Person> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new Label("total", new LambdaModel<>(() -> this.statementService.getTotal(this.getModelObject()), a -> {
        })));

        this.add(new ListView<BankAccount>("bankAccountList", this.bankAccountService.findByAdministrator(this.getModelObject())) {
            @Override
            protected void populateItem(ListItem<BankAccount> item) {
                item.add(new Label("number", new LambdaModel<>(() -> item.getModelObject().getNumber(), s -> item.getModelObject().setNumber(s))));
                item.add(new Label("total", new LambdaModel<>(() -> BankAccountListInfoPanel.this.statementService.getTotal(item.getModelObject()), bigDecimal -> {
                })));
            }
        });
    }
}
