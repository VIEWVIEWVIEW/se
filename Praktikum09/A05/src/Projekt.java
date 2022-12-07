import java.util.ArrayList;

public class Projekt {

	public String Name;
	public Ansprechpartner Ansprechpartner;
	private ArrayList<Student> Studenten;

	public ArrayList<Student> getStudenten() {
		return this.Studenten;
	}


	public void setStudenten(ArrayList<Student> studenten) {
		if (Studenten.size() > 3) {
			throw new IllegalArgumentException("Studenten.size() > 3");
		}

		if (Studenten.size() < 2) {
			throw new IllegalArgumentException("Studenten.size() < 2");
		}

		for (Student student : studenten) {
			student.Projekt = this;
		}
		this.Studenten = studenten;
	}

	public void addStudent(Student student) {
		if (Studenten.size() > 3) {
			throw new IllegalArgumentException("Studenten.size() > 3");
		}

		student.Projekt = this;
		this.Studenten.add(student);
	}

	public void removeStudent(Student student) {
		if (Studenten.size() < 2) {
			throw new IllegalArgumentException("Studenten.size() < 2");
		}

		this.Studenten.remove(student);
	}

	public void removeStudentByMatrikelnummer(String matrikelnummer) {
		if (Studenten.size() < 2) {
			throw new IllegalArgumentException("Studenten.size() < 2");
		}

		for (Student student : Studenten) {
			if (student.Matrikelnummer.equals(matrikelnummer)) {
				this.Studenten.remove(student);
				break;
			}
		}
	}

	/**
	 * 
	 * @param Studenten
	 */
	public Projekt(ArrayList<Student> studenten) {
		setStudenten(studenten);
	}
}