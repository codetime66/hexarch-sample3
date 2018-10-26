package br.com.stelo.vendedor.cadastro.models.constraints;

public class BairroValidator implements FieldValidator, Size {

	@Override
	public boolean perform(Object value) {
		if (value == null || !(value instanceof String)) {
			return false;
		}
		if (((String)value).isEmpty()) {
			return false;
		}		
		
		return validateBairro((String) value);
	}

	private boolean validateBairro(String bairro) {
        return check(bairro,100);
	}
}
