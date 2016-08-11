package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtil {

	public static boolean isThisDateValid(String dateToValidate, String dateFormat) {

		if (dateToValidate == "") {
			return true;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static Date convertToDate(String dateToValidate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		Date date = sdf.parse(dateToValidate);
		return date;
	}
}