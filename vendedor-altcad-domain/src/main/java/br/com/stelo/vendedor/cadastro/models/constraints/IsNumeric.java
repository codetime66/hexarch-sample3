package br.com.stelo.vendedor.cadastro.models.constraints;

public interface IsNumeric {
	static boolean check(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}
}
