package be.ghostwritertje.wicket.car.pages;

import be.ghostwritertje.domain.Car;
import be.ghostwritertje.services.car.CarService;
import be.ghostwritertje.wicket.BasePage;
import be.ghostwritertje.wicket.LocalDateTextField;
import be.ghostwritertje.wicket.person.PersonModel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.time.LocalDate;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class CarPage extends BasePage<Car> {

    @SpringBean
    private CarService carService;

    protected CarPage(IModel<Car> model) {
        super(model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<Car> form = new Form<Car>("form", this.getModel()) {
            @Override
            public void onSubmit() {
                super.onSubmit();
                Car savedCar = CarPage.this.carService.save(this.getModelObject());
                this.setResponsePage(new CarListPage(new PersonModel(new Model<Integer>(savedCar.getOwner().getId()))));
            }
        };

        form.add(new TextField<String>("brand", new LambdaModel<String>(() -> this.getModelObject().getBrand(), brand -> this.getModelObject().setBrand(brand))));
        form.add(new TextField<String>("model", new LambdaModel<String>(() -> this.getModelObject().getModel(), model -> this.getModelObject().setModel(model))));
        form.add(new LocalDateTextField("date", new LambdaModel<LocalDate>(() -> this.getModelObject().getPurchaseDate(), date -> this.getModelObject().setPurchaseDate(date))));
        form.add(new SubmitLink("save"));

        this.add(form);
    }
}
