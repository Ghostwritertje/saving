package be.ghostwritertje.wicket.person.pages;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.mongo.dao.StockRepository;
import be.ghostwritertje.mongo.domain.HistoricPrice;
import be.ghostwritertje.mongo.domain.Stock;
import be.ghostwritertje.services.person.PersonService;
import be.ghostwritertje.wicket.BasePage;
import be.ghostwritertje.wicket.CustomSession;
import be.ghostwritertje.wicket.DashboardPage;
import be.ghostwritertje.wicket.UnAuthorizedAllowed;
import be.ghostwritertje.wicket.person.PersonModel;
import org.apache.log4j.Logger;
import org.apache.wicket.authentication.IAuthenticationStrategy;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class LoginPage extends BasePage<Person> implements UnAuthorizedAllowed {
    @SpringBean
    private PersonService personService;

    @SpringBean
    private StockRepository stockRepository;

    private static final Logger logger = Logger.getLogger(LoginPage.class);

    public LoginPage() {
        super(new Model<>(new Person()));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        Stock stock = new Stock();
        stock.setQuote("AAPL");
        stock.setCurrentValue(251.20);
        HistoricPrice e = new HistoricPrice();
        e.setPrice(451.24);
        e.setDate(LocalDate.now());
        stock.getHistoricPriceList().add(e);
        this.stockRepository.save(stock);

        this.add(new Label("aapl", this.stockRepository.findByQuote("AAPL").getCurrentValue()));

        Form<Person> form = new LoginForm("form", this.getModel());
        this.add(form);
    }


    class LoginForm extends Form<Person> {

        private final IModel<Boolean> rememberMe;

        public LoginForm(String id, IModel<Person> model) {
            super(id, model);
            this.rememberMe = new Model<>(true);
        }

        @Override
        public void onSubmit() {
            super.onSubmit();
            Optional.ofNullable(LoginPage.this.personService.logIn(LoginPage.this.getModelObject())).ifPresent(this::login);
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();
            this.add(new TextField<String>("username", new LambdaModel<>(() -> this.getModel().getObject().getUsername(), username -> this.getModel().getObject().setUsername(username))).setRequired(true));
            this.add(new PasswordTextField("password", new LambdaModel<>(() -> this.getModelObject().getPassword(), password -> this.getModelObject().setPassword(password))).setRequired(true));

            WebMarkupContainer rememberMeContainer = new WebMarkupContainer("rememberMeContainer");
            this.add(rememberMeContainer);

            // Add rememberMe checkbox
            rememberMeContainer.add(new CheckBox("rememberMe", this.rememberMe));
            this.add(new SubmitLink("save"));
        }

        private void login(Person person) {
            IAuthenticationStrategy strategy = getApplication().getSecuritySettings()
                    .getAuthenticationStrategy();

            if (AuthenticatedWebSession.get().signIn(person.getUsername(), person.getUsername())) {
                CustomSession.get().setLoggedInPerson(person);
                if (this.rememberMe.getObject()) {
                    strategy.save(person.getUsername(), person.getUsername());
                } else {
                    strategy.remove();
                }
                logger.info(String.format("User %s has logged in", person.getUsername()));
                this.setResponsePage(new DashboardPage(new PersonModel(new Model<Integer>(person.getId()))));
            } else {
                error(getLocalizer().getString("signInFailed", this, "Sign in failed"));
            }
        }
    }
}
