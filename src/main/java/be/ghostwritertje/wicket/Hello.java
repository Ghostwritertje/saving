package be.ghostwritertje.wicket;

import be.ghostwritertje.services.PersonService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
public class Hello extends BasePage {

    @SpringBean
    private PersonService personService;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new Label("username", personService.getLoggedInUser()));
    }
}
