import be.ghostwritertje.domain.User;
import be.ghostwritertje.services.UserService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Ghostwritertje
 * Date: 30-Sep-16.
 */
public class UsersPage extends WebPage {
    @SpringBean
    private UserService userService;

    @Override
    protected void onInitialize() {
        super.onInitialize();
        this.add(new ListView<User>("users", this.userService.findAll()) {

            @Override
            protected void populateItem(ListItem<User> item) {
                item.add(new Label("username"));
            }
        });
    }
}
