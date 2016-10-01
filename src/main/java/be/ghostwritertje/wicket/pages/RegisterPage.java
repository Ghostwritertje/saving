package be.ghostwritertje.wicket.pages;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.services.PersonService;
import be.ghostwritertje.wicket.BasePage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class RegisterPage extends BasePage<Person> {

    @SpringBean
    private PersonService personService;

    public RegisterPage() {
        super(new Model<>(new Person()));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<Person> form = new Form<>("form", this.getModel());

        form.add(new TextField<String>("username", new LambdaModel<>(() -> this.getModel().getObject().getUsername(), username -> this.getModel().getObject().setUsername(username))).setRequired(true));
        form.add(new PasswordTextField("password", new LambdaModel<>(() -> this.getModelObject().getPassword(), password -> this.getModelObject().setPassword(password))).setRequired(true));

        form.add(new SubmitLink("save") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                RegisterPage.this.personService.save(RegisterPage.this.getModelObject());
                this.setResponsePage(new LoginPage());
            }
        });

        this.add(form);
    }
}
