package br.com.stelo.vendedor.cadastro.models.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BroadValidator implements ConstraintValidator<BroadFields, Object> {

	FieldValidator validator;

	@Override
	public void initialize(BroadFields constraintAnnotation) {
		try {
			validator = getValidator(constraintAnnotation.checkclass());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			validator = null;
			e.printStackTrace();
		}
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return (validator == null) ? false : validator.perform(value);
	}

	private FieldValidator getValidator(String clazz)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (FieldValidator) Class.forName(clazz).newInstance();
	}

}
