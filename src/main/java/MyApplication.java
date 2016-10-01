import be.ghostwritertje.wicket.CustomSession;
import be.ghostwritertje.wicket.pages.Hello;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
public class MyApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return Hello.class;
    }

    @Override
    protected void init() {
        super.init();
        super.getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        this.configureBootstrap();
    }

    private void configureBootstrap() {
        IBootstrapSettings settings = new BootstrapSettings();
        Bootstrap.install(this, settings);
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new CustomSession(request);
    }
}
