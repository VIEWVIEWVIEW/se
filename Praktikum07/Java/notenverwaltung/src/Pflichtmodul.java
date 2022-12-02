import java.util.*;


public class Pflichtmodul {

	private List<Note> noten;
	public int ects = 0;
	public String name;
	public int semester = 1;

	final private int maximalAnzahlNoten = 3;

	/**
	 * 
	 * @param ectsWertDesModuls Der Wert des Modules in ECTS Punkten
	 * @param startSemester Das Semester in dem das Modul beginnt
	 * @param nameDesModuls
	 */
	public Pflichtmodul(int ectsWertDesModuls, int startSemester, String nameDesModuls) {
		name = nameDesModuls;
		ects = ectsWertDesModuls;
		semester = startSemester;
		noten = new ArrayList<Note>();
	}

	/**
	 * 
	 * @param note
	 */
	public void noteHinzufuegen(Note note) {
		if (noten.size() < maximalAnzahlNoten) {
			noten.add(note);
		} else {
			throw new IllegalArgumentException("Maximal 3 Noten pro Modul");
		}
	}

	public void letzteNoteEntfernen() {
		if (noten.size() > 0) {
			noten.remove(noten.size() - 1);
		} else {
			throw new IllegalArgumentException("Keine Noten vorhanden");
		}
	}

}