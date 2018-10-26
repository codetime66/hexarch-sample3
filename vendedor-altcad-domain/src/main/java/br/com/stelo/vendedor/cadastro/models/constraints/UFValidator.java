package br.com.stelo.vendedor.cadastro.models.constraints;

public class UFValidator implements FieldValidator {

	@Override
	public boolean perform(Object value) {
		if (value == null || !(value instanceof String)) {
			return false;
		}

		return validateUF((String) value);
	}

	private boolean validateUF(String uf) {
		return (uf.matches("[A-Z]{2}"));
	}
}
