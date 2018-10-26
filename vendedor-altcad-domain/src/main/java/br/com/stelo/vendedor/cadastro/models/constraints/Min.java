package br.com.stelo.vendedor.cadastro.models.constraints;

public interface Min {
	default boolean check(Object value, int min) {
		try {
			Double value_d = (Double) value;
			return value_d >= min;
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
	}
}
///.matches("-?\\d+(\\.\\d+)?")
