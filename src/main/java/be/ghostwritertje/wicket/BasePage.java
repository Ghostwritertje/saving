package be.ghostwritertje.wicket;

import be.ghostwritertje.wicket.pages.PersonsPage;
import be.ghostwritertje.wicket.pages.RegisterPage;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;

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

        this.add(new BookmarkablePageLink("usersLink", PersonsPage.class));
        this.add(new BookmarkablePageLink("registerLink", RegisterPage.class));

    }


}
