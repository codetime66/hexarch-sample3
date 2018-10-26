package br.com.stelo.vendedor.cadastro.models.constraints;

public class PhoneValidator implements FieldValidator {

	@Override
	public boolean perform(Object value) {
		if (value == null) {
			return true;
		}
	    if(!(value instanceof String)) {
			return false;
		}
		if (((String)value).isEmpty()) {
			return true;
		}
		return validatePhoneNumber((String) value);
	}

	private boolean validatePhoneNumber(String phoneNo) {
		return (phoneNo.matches("\\d{2}[\\s]\\d{9}"));
	}
}
