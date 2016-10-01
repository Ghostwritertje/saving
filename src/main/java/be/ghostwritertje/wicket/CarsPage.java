package be.ghostwritertje.wicket;

import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Person;
import be.ghostwritertje.services.CarService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class CarsPage extends BasePage<Person> {

    @SpringBean
    private CarService carService;

    protected CarsPage(IModel<Person> model) {
        super(model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new ListView<Car>("cars", this.carService.findAll(this.getModelObject())) {

            @Override
            protected void populateItem(ListItem<Car> item) {
                item.add(new Label("brand", item.getModelObject().getBrand()));
                item.add(new Label("model", item.getModelObject().getModel()));
                item.add(new Label("purchaseDate", item.getModelObject().getPurchaseDate()));

            }
        });

    }
}
