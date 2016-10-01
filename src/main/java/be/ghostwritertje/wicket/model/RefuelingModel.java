package be.ghostwritertje.wicket.model;

import be.ghostwritertje.domain.Refueling;
import be.ghostwritertje.services.RefuelingService;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class RefuelingModel extends LoadableModel<Refueling> {

    @SpringBean
    private RefuelingService refuelingService;

    private final IModel<Integer> idModel;

    public RefuelingModel(IModel<Integer> idModel) {
        super();
        this.idModel = idModel;
    }

    @Override
    protected Refueling load() {
        return this.refuelingService.findOne(this.idModel.getObject());
    }
}
