package be.ghostwritertje.wicket;

import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Refueling;
import be.ghostwritertje.services.RefuelingService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class RefuelingsPage extends BasePage<Car> {

    @SpringBean
    private RefuelingService refuelingService;

    protected RefuelingsPage(IModel<Car> model) {
        super(model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        this.add(new ListView<Refueling>("refuelings", this.refuelingService.findByCar(this.getModelObject())) {

            @Override
            protected void populateItem(ListItem<Refueling> item) {
                item.add(new Label("date", item.getModelObject().getDate()));
                item.add(new Label("liters", item.getModelObject().getLiters()));
                item.add(new Label("price", item.getModelObject().getPrice()));

            }
        });
    }
}
