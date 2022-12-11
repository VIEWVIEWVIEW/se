import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Organisation fhswf = new Organisation();
        fhswf.name = "FH Südwestfalen";

        Ansprechpartner ansprechpartner = new Ansprechpartner(fhswf);
        ansprechpartner.vorname = "Max";
        ansprechpartner.nachname = "Mustermann";
        ansprechpartner.email = "max@mustermann.de";

        ArrayList<Student> studenten = new ArrayList<Student>();
        Student student1 = new Student();
        student1.vorname = "Max";
        student1.nachname = "Mustermann";
        student1.matrikelnummer = "123456";
        studenten.add(student1);

        Student student2 = new Student();
        student2.vorname = "Maxima";
        student2.nachname = "Musterfrau";
        student2.matrikelnummer = "234567";
        studenten.add(student2);

        Projekt projekt = new Projekt(studenten);
        projekt.name = "Beispielprojekt";
        projekt.ansprechpartner = ansprechpartner;

        projekt.projektstatus = Projektstatus.Angenommen;

    }
}