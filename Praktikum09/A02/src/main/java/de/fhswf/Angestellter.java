package de.fhswf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Angestellter extends Person {
	public Date Eintrittsdatum;

	public String toString() {
		return "Angestellter{" +
				"Eintrittsdatum=" + Eintrittsdatum +
				"} " + super.toString();
	}
}