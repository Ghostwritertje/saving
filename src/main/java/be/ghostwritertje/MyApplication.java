package be.ghostwritertje;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
public class MyApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return Hello.class;
    }
}
