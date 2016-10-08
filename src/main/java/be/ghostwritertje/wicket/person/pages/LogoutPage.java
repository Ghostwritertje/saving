package be.ghostwritertje.wicket.person.pages;


import be.ghostwritertje.domain.Person;
import be.ghostwritertje.wicket.BasePage;

/**
 * Created by Jorandeboever
 * Date: 08-Oct-16.
 */
public class LogoutPage extends BasePage<Person> {

    public LogoutPage() {
        getSession().invalidate();
    }
}
