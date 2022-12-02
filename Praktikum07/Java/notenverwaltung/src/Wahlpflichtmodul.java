import java.util.*;

public class Wahlpflichtmodul {

	public List<Note> noten;
	public int ects = 0;
	public Wahlpflichtfaecher name;
	public int semester = 1;

	final private int maximalAnzahlNoten = 3;

	/**
	 * 
	 * @param ectsWertDesModuls
	 * @param startSemester
	 * @param wahlpflichtfach
	 */
	public Wahlpflichtmodul(int ectsWertDesModuls, int startSemester, Wahlpflichtfaecher wahlpflichtfach) {
		noten = new ArrayList<Note>();
		name = wahlpflichtfach;
		ects = ectsWertDesModuls;
		semester = startSemester;
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