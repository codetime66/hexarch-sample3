package br.com.stelo.vendedor.cadastro.models.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class TelefoneValidator implements ConstraintValidator<TelefoneFields, Object> {

	private static final Logger log = LoggerFactory.getLogger(TelefoneValidator.class);

	String firstPhone;
	String secondPhone;

	@Override
	public void initialize(TelefoneFields constraintAnnotation) {
		firstPhone = constraintAnnotation.firstPhone();
		secondPhone = constraintAnnotation.secondPhone();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		try {
			
			log.info("### TelefoneValidator START");
			
			Object firstPhoneValue = getFieldValue(object, firstPhone);
			Object secondPhoneValue = getFieldValue(object, secondPhone);

			if (firstPhoneValue == null && secondPhoneValue == null) {
				log.info("### TelefoneValidator 1");
				return false;
			}

			if (!(firstPhoneValue instanceof String) || !(secondPhoneValue instanceof String)) {
				log.info("### TelefoneValidator 2");
				throw new IllegalArgumentException("Illegal method signature, expected two parameters of type String.");
			}

			if ((firstPhoneValue == null || ((String) firstPhoneValue).isEmpty())
					&& (secondPhoneValue == null || ((String) secondPhoneValue).isEmpty())) {
				log.info("### TelefoneValidator 3");
				return false;
			}
		} catch (Exception e) {
			// TODO // log error
			e.printStackTrace();
			log.info("### TelefoneValidator 4");
			return false;
		}
		log.info("### TelefoneValidator 5");
		return true;
	}

	private Object getFieldValue(Object object, String fieldName) throws Exception {
		Class<?> clazz = object.getClass();
		Field phoneField = clazz.getDeclaredField(fieldName);
		phoneField.setAccessible(true);
		return phoneField.get(object);
	}
}
