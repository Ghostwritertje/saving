package be.ghostwritertje;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Created by Ghostwritertje
 * Date: 30-Sep-16.
 */
public class BasePage extends WebPage {

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new BookmarkablePageLink("users", UsersPage.class));
    }
}
