package be.ghostwritertje.wicket;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

import java.util.function.Predicate;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class VisibilityBehavior<X extends Component> extends Behavior {

    private final Predicate<? super X> visibilityLogic;

    public VisibilityBehavior(Predicate<? super X> visibilityLogic) {
        this.visibilityLogic = visibilityLogic;
    }

    @Override
    public void onConfigure(Component component) {
        super.onConfigure(component);
        component.setVisibilityAllowed(component.isVisibilityAllowed() && this.visibilityLogic.test((X) component));
    }
}
