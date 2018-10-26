package br.com.stelo.vendedor.cadastro.models.constraints;

public class CidadeValidator implements FieldValidator, Size {

	@Override
	public boolean perform(Object value) {
		if (value == null || !(value instanceof String)) {
			return false;
		}
		if (((String)value).isEmpty()) {
			return false;
		}		
		
		return validateCidade((String) value);
	}

	private boolean validateCidade(String cidade) {
        return check(cidade,100);
	}
}
