package be.ghostwritertje.wicket;

import be.ghostwritertje.wicket.pages.LoginPage;
import be.ghostwritertje.wicket.pages.PersonListPage;
import be.ghostwritertje.wicket.pages.RegisterPage;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LambdaModel;

/**
 * Created by Ghostwritertje
 * Date: 30-Sep-16.
 */
public abstract class BasePage<T> extends GenericWebPage<T> {
    protected BasePage() {
        super();
    }

    protected BasePage(IModel<T> model) {
        super(model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new BookmarkablePageLink("usersLink", PersonListPage.class));
        this.add(new BookmarkablePageLink("registerLink", RegisterPage.class));
        this.add(new BookmarkablePageLink("loginLink", LoginPage.class));

        this.add(new Label("loggedInUsername", new LambdaModel<>(() -> CustomSession.get().getLoggedInPerson().getUsername(), s -> {
        })) {
            @Override
            public boolean isVisible() {
                return CustomSession.get().getLoggedInPerson() != null;//todo_joran
            }
        });

    }


}
