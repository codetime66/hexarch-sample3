package br.com.stelo.vendedor.cadastro.models.constraints;

public class MobileValidator implements FieldValidator {

	@Override
	public boolean perform(Object value) {
		if (value == null) {
			return false;
		}
	    if(!(value instanceof String)) {
			return false;
		}
		if (((String)value).isEmpty()) {
			return false;
		}
		return validateMobileNumber((String) value);
	}

	private boolean validateMobileNumber(String phoneNo) {
		return (phoneNo.matches("\\d{2}[\\s]\\d{9}"));
	}
}
