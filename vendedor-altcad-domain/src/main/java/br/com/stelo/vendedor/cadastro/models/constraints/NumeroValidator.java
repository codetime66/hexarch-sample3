package br.com.stelo.vendedor.cadastro.models.constraints;

public class NumeroValidator implements FieldValidator, Size {

	@Override
	public boolean perform(Object value) {
		if (value == null || !(value instanceof String)) {
			return false;
		}
		if (((String)value).isEmpty()) {
			return false;
		}		
		
		return validateNumero((String) value);
	}

	private boolean validateNumero(String numero) {
        return check(numero,9);
	}
}
