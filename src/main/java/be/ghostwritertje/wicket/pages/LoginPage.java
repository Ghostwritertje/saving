package be.ghostwritertje.wicket.pages;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.services.PersonService;
import be.ghostwritertje.wicket.BasePage;
import be.ghostwritertje.wicket.CustomSession;
import be.ghostwritertje.wicket.model.PersonModel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.Optional;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class LoginPage extends BasePage<Person> {
    @SpringBean
    private PersonService personService;

    public LoginPage() {
        super(new Model<>(new Person()));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<Person> form = new Form<Person>("form", this.getModel()) {
            @Override
            public void onSubmit() {
                super.onSubmit();
                Optional.ofNullable(LoginPage.this.personService.logIn(LoginPage.this.getModelObject())).ifPresent(person -> {
                    CustomSession.get().setLoggedInPerson(person);
                    this.setResponsePage(new CarListPage(new PersonModel(new Model<Integer>(person.getId()))));
                });
            }
        };

        form.add(new TextField<String>("username", new LambdaModel<>(() -> this.getModel().getObject().getUsername(), username -> this.getModel().getObject().setUsername(username))).setRequired(true));
        form.add(new PasswordTextField("password", new LambdaModel<>(() -> this.getModelObject().getPassword(), password -> this.getModelObject().setPassword(password))).setRequired(true));

        form.add(new SubmitLink("save"));

        this.add(form);
    }
}
