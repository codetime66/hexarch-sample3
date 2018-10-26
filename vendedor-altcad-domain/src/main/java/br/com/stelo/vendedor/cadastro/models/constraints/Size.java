package br.com.stelo.vendedor.cadastro.models.constraints;

public interface Size {
	public default boolean check(Object value, int size) {
		if(value!=null && value instanceof String) {
			return ((String)value).length()<=size;
		}
		return false;
	}
}
