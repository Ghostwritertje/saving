package be.ghostwritertje.wicket;

import be.ghostwritertje.utilities.DateUtilities;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LambdaModel;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public class LocalDateTextField extends DateTextField {

    public LocalDateTextField(String id, IModel<LocalDate> model) {
        super(id, new LambdaModel<Date>(() -> DateUtilities.toUtilDate(model.getObject()), date -> model.setObject(DateUtilities.toLocalDate(date))));
    }


}
