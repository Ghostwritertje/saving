package be.ghostwritertje.wicket.pages;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.services.PersonService;
import be.ghostwritertje.wicket.BasePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Ghostwritertje
 * Date: 30-Sep-16.
 */
public class PersonListPage extends BasePage<Void> {
    @SpringBean
    private PersonService personService;

    @Override
    protected void onInitialize() {
        super.onInitialize();
        this.add(new ListView<Person>("users", this.personService.findAll()) {

            @Override
            protected void populateItem(ListItem<Person> item) {
                item.add(new Label("username", item.getModelObject().getUsername()));
                item.add(new Link<Person>("carsList") {
                    @Override
                    public void onClick() {
                        setResponsePage(new CarListPage(item.getModel()));
                    }
                });

            }
        });
    }
}
