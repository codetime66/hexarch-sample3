package br.com.stelo.vendedor.cadastro.models.constraints;

public class CEPValidator implements FieldValidator {

	@Override
	public boolean perform(Object value) {
		if (value == null || !(value instanceof String)) {
			return false;
		}
		
		return validateCEPNumber((String) value);
	}

	private boolean validateCEPNumber(String cep) {
		return (cep.matches("\\d{8}"));
	}
}
