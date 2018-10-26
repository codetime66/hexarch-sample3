package br.com.stelo.vendedor.cadastro.models.constraints;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class DateValidator implements FieldValidator {

	@Override
	public boolean perform(Object value) {
		if (value == null || !(value instanceof String)) {
			return false;
		}

		return isDateValid((String) value, "dd/MM/yyyy");
	}

	private boolean isDateValid(String dateToValidate, String dateFromat) {

		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
		} catch (ParseException e) {
			return false;
		}

		return true;
	}
}
