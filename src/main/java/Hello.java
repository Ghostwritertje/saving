import be.ghostwritertje.BasePage;
import be.ghostwritertje.services.UserService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
public class Hello extends BasePage{

    @SpringBean
    private UserService userService;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new Label("username", userService.getLoggedInUser()));
    }
}
