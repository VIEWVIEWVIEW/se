package de.fhswf;

public abstract class Person {
	public int Id;
	public String Vorname;
	public String Nachname;
	public String Plz;
	public String Ort;
	public String Strasse;

	public String toString() {
		return "Person{" +
				"Id=" + Id +
				", Vorname='" + Vorname + '\'' +
				", Nachname='" + Nachname + '\'' +
				", Plz='" + Plz + '\'' +
				", Ort='" + Ort + '\'' +
				", Strasse='" + Strasse + '\'' +
				'}';
	}
}