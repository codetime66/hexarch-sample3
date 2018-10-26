package br.com.stelo.vendedor.cadastro.models.constraints;

public class ComplementoValidator implements FieldValidator, Size {

	@Override
	public boolean perform(Object value) {
		if (value == null) {
			return true;
		}
		if (!(value instanceof String)) {
			return false;
		}
		if (((String)value).isEmpty()) {
			return true;
		}		
		
		return validateComplemento((String) value);
	}

	private boolean validateComplemento(String complemento) {
        return check(complemento,100);
	}
}
