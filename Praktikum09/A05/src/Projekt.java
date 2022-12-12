import java.util.ArrayList;

public class Projekt {

	public String name;
	public Ansprechpartner ansprechpartner;
	public Projektstatus projektstatus;
	private ArrayList<Student> studenten;

	public ArrayList<Student> getStudenten() {
		return this.studenten;
	}


	public void setStudenten(ArrayList<Student> studenten) {
		if (studenten.size() > 3) {
			throw new IllegalArgumentException("Studenten.size() > 3");
		}

		if (studenten.size() < 2) {
			throw new IllegalArgumentException("Studenten.size() < 2");
		}

		this.studenten = studenten;
	}

	public void addStudent(Student student) {
		if (studenten.size() > 3) {
			throw new IllegalArgumentException("Studenten.size() > 3");
		}

		this.studenten.add(student);
	}

	public void removeStudent(Student student) {
		if (studenten.size() < 2) {
			throw new IllegalArgumentException("Studenten.size() < 2");
		}

		this.studenten.remove(student);
	}

	public void removeStudentByMatrikelnummer(String matrikelnummer) {
		if (studenten.size() < 2) {
			throw new IllegalArgumentException("Studenten.size() < 2");
		}

		for (Student student : studenten) {
			if (student.matrikelnummer.equals(matrikelnummer)) {
				this.studenten.remove(student);
				break;
			}
		}
	}

	public Projekt(ArrayList<Student> studenten) {
		projektstatus = Projektstatus.WartenAufFeedback;
		setStudenten(studenten);
	}
}