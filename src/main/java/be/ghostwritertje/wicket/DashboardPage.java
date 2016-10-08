package be.ghostwritertje.wicket;

import be.ghostwritertje.domain.Car;
import be.ghostwritertje.domain.Person;
import be.ghostwritertje.services.car.CarService;
import be.ghostwritertje.wicket.car.panel.CarInfoPanel;
import be.ghostwritertje.wicket.model.BankAccountListInfoPanel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 02-Oct-16.
 */
public class DashboardPage extends BasePage<Person> {
    @SpringBean
    private CarService carService;

    public DashboardPage() {
        super(new Model<>(CustomSession.get().getLoggedInPerson()));
    }

    public DashboardPage(IModel<Person> model) {
        super(model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        List<Car> carList = this.carService.findAll(this.getModelObject());

        this.add(new ListView<Car>("carListView", carList) {
            @Override
            protected void populateItem(ListItem<Car> item) {
                item.add(new CarInfoPanel("carInfo", item.getModel()));
            }
        });

        this.add(new BankAccountListInfoPanel("bankAccountView", this.getModel()));
    }
}
