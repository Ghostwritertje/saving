package be.ghostwritertje.wicket.pages;

import be.ghostwritertje.domain.Refueling;
import be.ghostwritertje.services.RefuelingService;
import be.ghostwritertje.wicket.BasePage;
import be.ghostwritertje.wicket.LocalDateTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.time.LocalDate;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class RefuelingPage extends BasePage<Refueling> {

    @SpringBean
    private RefuelingService refuelingService;

    protected RefuelingPage(IModel<Refueling> model) {
        super(model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<Refueling> form = new Form<>("form", this.getModel());

        IModel<LocalDate> localDateLambdaModel = new LambdaModel<>(() -> this.getModel().getObject().getDate(), localDate -> this.getModel().getObject().setDate(localDate));
        form.add(new LocalDateTextField("date", localDateLambdaModel));
        form.add(new NumberTextField<Double>("liters", new LambdaModel<Double>(() -> this.getModelObject().getLiters(), liters -> this.getModelObject().setLiters(liters)), Double.class));
        form.add(new NumberTextField<Double>("price", new LambdaModel<Double>(() -> this.getModelObject().getPrice(), price -> this.getModelObject().setPrice(price)), Double.class));

        form.add(new SubmitLink("save") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                this.setResponsePage(new Hello());
            }
        });

        this.add(form);
    }

}
