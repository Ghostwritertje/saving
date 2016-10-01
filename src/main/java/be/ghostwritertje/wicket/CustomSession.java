package be.ghostwritertje.wicket;

import be.ghostwritertje.domain.Person;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class CustomSession extends WebSession {

    private Person loggedInPerson = null;

    /**
     * Constructor. Note that {@link RequestCycle} is not available until this constructor returns.
     *
     * @param request The current request
     */
    public CustomSession(Request request) {
        super(request);
    }

    public static CustomSession get() {
        return (CustomSession) Session.get();
    }

    public Person getLoggedInPerson() {
        return loggedInPerson;
    }

    public void setLoggedInPerson(Person loggedInPerson) {
        this.loggedInPerson = loggedInPerson;
    }
}
