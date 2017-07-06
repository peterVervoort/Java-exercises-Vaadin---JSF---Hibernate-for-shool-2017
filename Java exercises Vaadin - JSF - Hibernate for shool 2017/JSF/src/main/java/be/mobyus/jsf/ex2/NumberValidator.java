package be.mobyus.jsf.ex2;

import com.sun.faces.util.MessageFactory;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.internal.annotations.ObjectFactoryAnnotation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by java on 31.10.16.
 */
@FacesValidator()
public class NumberValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException{
        if (value != null && !NumberUtils.isDigits(value.toString())){
            throw new ValidatorException(MessageFactory.getMessage("not_numerical", value.toString()));
        }
    }
}
