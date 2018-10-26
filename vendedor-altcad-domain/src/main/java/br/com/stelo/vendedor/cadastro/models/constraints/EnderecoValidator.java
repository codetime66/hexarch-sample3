package br.com.stelo.vendedor.cadastro.models.constraints;

public class EnderecoValidator implements FieldValidator, Size {

	@Override
	public boolean perform(Object value) {
		if (value == null || !(value instanceof String)) {
			return false;
		}
		if (((String)value).isEmpty()) {
			return false;
		}		
		
		return validateEndereco((String) value);
	}

	private boolean validateEndereco(String endereco) {
        return check(endereco,255);
	}
}
