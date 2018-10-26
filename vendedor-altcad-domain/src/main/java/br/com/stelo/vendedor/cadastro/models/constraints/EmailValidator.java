package br.com.stelo.vendedor.cadastro.models.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements FieldValidator, Size {

	@Override
	public boolean perform(Object value) {
		if(value==null || !(value instanceof String)) {
			return false;
		}
		
		return validateEmail((String)value)
				&& check((String)value,150);
	}

	public boolean validateEmail(String email) {
		String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
