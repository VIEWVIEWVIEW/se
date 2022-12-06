package de.fhswf;

import java.util.Date;

public class StudentischeHilfskraft extends Person {

	public String Matrikelnummer;
	public Date BeginnArbeitsvertrag;
	public Date EndeArbeitsvertrag;
	public int StundenlohnInCent;
	public static int StandardStundenlohnInCent = 1200; // 12.00€

	@Override
	public String toString() {
		return "StudentischeHilfskraft{" +
				"Matrikelnummer='" + Matrikelnummer + '\'' +
				", BeginnArbeitsvertrag=" + BeginnArbeitsvertrag +
				", EndeArbeitsvertrag=" + EndeArbeitsvertrag +
				", StundenlohnInCent=" + StundenlohnInCent +
				"} " + super.toString();
	}
}