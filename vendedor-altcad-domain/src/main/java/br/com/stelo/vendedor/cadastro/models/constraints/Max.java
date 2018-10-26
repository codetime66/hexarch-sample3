package br.com.stelo.vendedor.cadastro.models.constraints;

public interface Max {
	default boolean check(Object value, int max) {
		try {
			Double value_d = (Double) value;
			return value_d <= max;
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
	}
}
///.matches("-?\\d+(\\.\\d+)?")
