package de.fhswf;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    public static void printMenu() throws ParseException {
        while (true) {

        System.out.println("1. Alle Angestellten anzeigen");
        System.out.println("2. Get Angestellter by id");
        System.out.println("3. Create Angestellter");
        System.out.println("4. Update Angestellter");
        System.out.println("5. Delete Angestellter");
        System.out.println("---------------------------");
        System.out.println("6. Alle Studentische Hilfskräfte anzeigen");
        System.out.println("7. Get Studentische Hilfskraft by id");
        System.out.println("8. Create Studentische Hilfskraft");
        System.out.println("9. Update Studentische Hilfskraft");
        System.out.println("10. Delete Studentische Hilfskraft");
        System.out.println("0. Exit");


        Integer choice = 0;
        Scanner scanner = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD");

        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                CrudAngestellter crudAngestellter = new CrudAngestellter();
                List<Angestellter> angestellte = crudAngestellter.readAll();
                for (Angestellter a : angestellte) {
                    System.out.println(a);
                }
                break;
            case 2:
                System.out.println("Geben Sie die ID ein:");
                Integer id = scanner.nextInt();
                CrudAngestellter crudAngestellter2 = new CrudAngestellter();
                Angestellter angestellter = crudAngestellter2.read(id);
                System.out.println(angestellter);
                break;
            case 3:
                System.out.println("Geben Sie den Vornamen ein:");
                String vorname = scanner.nextLine();
                System.out.println("Geben Sie den Nachnamen ein:");
                String nachname = scanner.nextLine();
                System.out.println("Geben Sie die PLZ ein:");
                String plz = scanner.nextLine();
                System.out.println("Geben Sie den Ort ein:");
                String ort = scanner.nextLine();
                System.out.println("Geben Sie die Strasse ein:");
                String strasse = scanner.nextLine();
                System.out.println("Geben Sie das Eintrittsdatum ein (YYYY-MM-DD):");
                String eintrittsdatum = scanner.nextLine();
                Angestellter angestellter2 = new Angestellter();
                angestellter2.Vorname = vorname;
                angestellter2.Nachname = nachname;
                angestellter2.Plz = plz;
                angestellter2.Ort = ort;
                angestellter2.Strasse = strasse;

                try {
                    angestellter2.Eintrittsdatum = df.parse(eintrittsdatum);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                CrudAngestellter crudAngestellter3 = new CrudAngestellter();
                crudAngestellter3.create(angestellter2);
                break;
            case 4:
                System.out.println("Geben Sie die ID ein:");
                Integer id2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Geben Sie den Vornamen ein:");
                String vorname2 = scanner.nextLine();
                System.out.println("Geben Sie den Nachnamen ein:");
                String nachname2 = scanner.nextLine();
                System.out.println("Geben Sie die PLZ ein:");
                String plz2 = scanner.nextLine();
                System.out.println("Geben Sie den Ort ein:");
                String ort2 = scanner.nextLine();
                System.out.println("Geben Sie die Strasse ein:");
                String strasse2 = scanner.nextLine();
                System.out.println("Geben Sie das Eintrittsdatum ein (YYYY-MM-DD):");
                String eintrittsdatum2 = scanner.nextLine();
                Angestellter angestellter3 = new Angestellter();
                angestellter3.Vorname = vorname2;
                angestellter3.Nachname = nachname2;
                angestellter3.Plz = plz2;
                angestellter3.Ort = ort2;
                angestellter3.Strasse = strasse2;
                try {
                    angestellter3.Eintrittsdatum = df.parse(eintrittsdatum2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                CrudAngestellter crudAngestellter4 = new CrudAngestellter();
                crudAngestellter4.update(id2, angestellter3);
                break;
            case 5:
                System.out.println("Geben Sie die ID ein:");
                Integer id3 = scanner.nextInt();
                CrudAngestellter crudAngestellter5 = new CrudAngestellter();
                crudAngestellter5.delete(id3);
                break;
            case 6:
                CrudStudentischeHilfskraft crudStudentischeHilfskraft = new CrudStudentischeHilfskraft();
                List<StudentischeHilfskraft> studentischeHilfskräfte = crudStudentischeHilfskraft.readAll();
                for (StudentischeHilfskraft s : studentischeHilfskräfte) {
                    System.out.println(s);
                }
                break;
            case 7:
                System.out.println("Geben Sie die ID ein:");
                Integer id4 = scanner.nextInt();
                CrudStudentischeHilfskraft crudStudentischeHilfskraft2 = new CrudStudentischeHilfskraft();
                StudentischeHilfskraft studentischeHilfskraft = crudStudentischeHilfskraft2.read(id4);
                System.out.println(studentischeHilfskraft);
                break;
            case 8:
                System.out.println("Geben Sie den Vornamen ein:");
                String vorname3 = scanner.nextLine();
                System.out.println("Geben Sie den Nachnamen ein:");
                String nachname3 = scanner.nextLine();
                System.out.println("Geben Sie die PLZ ein:");
                String plz3 = scanner.nextLine();
                System.out.println("Geben Sie den Ort ein:");
                String ort3 = scanner.nextLine();
                System.out.println("Geben Sie die Strasse ein:");
                String strasse3 = scanner.nextLine();
                System.out.println("Geben Sie Beginn Arbeitsvertrag ein(YYYY-MM-DD):");
                String beginnArbeitsvertrag = scanner.nextLine();
                System.out.println("Geben Sie Ende Arbeitsvertrag ein(YYYY-MM-DD):");
                String endeArbeitsvertrag = scanner.nextLine();
                System.out.println("Geben Sie die Matrikelnummer ein:");
                String matrikelnummer = scanner.nextLine();

                System.out.println("Geben Sie den Stundenlohn in Cent ein (z.B. 1200 für 12€/h. Der Standardlohn beträgt " + StudentischeHilfskraft.StandardStundenlohnInCent + "):");
                Integer stundenlohn = scanner.nextInt();
                scanner.nextLine();

                StudentischeHilfskraft studentischeHilfskraft2 = new StudentischeHilfskraft();
                studentischeHilfskraft2.Vorname = vorname3;
                studentischeHilfskraft2.Nachname = nachname3;
                studentischeHilfskraft2.Plz = plz3;
                studentischeHilfskraft2.Ort = ort3;
                studentischeHilfskraft2.Strasse = strasse3;
                try {
                    studentischeHilfskraft2.BeginnArbeitsvertrag = df.parse(beginnArbeitsvertrag);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    studentischeHilfskraft2.EndeArbeitsvertrag = df.parse(endeArbeitsvertrag);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                studentischeHilfskraft2.Matrikelnummer = matrikelnummer;
                studentischeHilfskraft2.StundenlohnInCent = stundenlohn;

                CrudStudentischeHilfskraft crudStudentischeHilfskraft3 = new CrudStudentischeHilfskraft();
                crudStudentischeHilfskraft3.create(studentischeHilfskraft2);
                break;
            case 9:
                System.out.println("Geben Sie die ID ein:");
                Integer id5 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Geben Sie den Vornamen ein:");
                String vorname4 = scanner.nextLine();
                System.out.println("Geben Sie den Nachnamen ein:");
                String nachname4 = scanner.nextLine();
                System.out.println("Geben Sie die PLZ ein:");
                String plz4 = scanner.nextLine();
                System.out.println("Geben Sie den Ort ein:");
                String ort4 = scanner.nextLine();
                System.out.println("Geben Sie die Strasse ein:");
                String strasse4 = scanner.nextLine();
                System.out.println("Geben Sie Beginn Arbeitsvertrag ein(YYYY-MM-DD):");
                String beginnArbeitsvertrag2 = scanner.nextLine();
                System.out.println("Geben Sie Ende Arbeitsvertrag ein(YYYY-MM-DD):");
                String endeArbeitsvertrag2 = scanner.nextLine();
                System.out.println("Geben Sie die Matrikelnummer ein:");
                String matrikelnummer2 = scanner.nextLine();

                System.out.println("Geben Sie den Stundenlohn in Cent ein (z.B. 1200 für 12€/h. Der Standardlohn beträgt " + StudentischeHilfskraft.StandardStundenlohnInCent + "):");
                Integer stundenlohn2 = scanner.nextInt();
                scanner.nextLine();

                StudentischeHilfskraft studentischeHilfskraft3 = new StudentischeHilfskraft();
                studentischeHilfskraft3.Vorname = vorname4;
                studentischeHilfskraft3.Nachname = nachname4;
                studentischeHilfskraft3.Plz = plz4;
                studentischeHilfskraft3.Ort = ort4;
                studentischeHilfskraft3.Strasse = strasse4;
                try {
                    studentischeHilfskraft3.BeginnArbeitsvertrag = df.parse(beginnArbeitsvertrag2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    studentischeHilfskraft3.EndeArbeitsvertrag = df.parse(endeArbeitsvertrag2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                studentischeHilfskraft3.Matrikelnummer = matrikelnummer2;
                studentischeHilfskraft3.StundenlohnInCent = stundenlohn2;

                CrudStudentischeHilfskraft crudStudentischeHilfskraft4 = new CrudStudentischeHilfskraft();
                crudStudentischeHilfskraft4.update(id5, studentischeHilfskraft3);
                break;
            case 10:
                System.out.println("Geben Sie die ID ein:");
                Integer id6 = scanner.nextInt();
                scanner.nextLine();
                CrudStudentischeHilfskraft crudStudentischeHilfskraft5 = new CrudStudentischeHilfskraft();
                crudStudentischeHilfskraft5.delete(id6);
                break;
            case 0:
                System.out.println("Programm wird beendet");
                System.exit(0);
                break;
            }
        }
    }


    public static void main(String[] args) {
        connection = null;
        try {
            // create a database connection
            connection = ConnectionFactory.getConnection();

            // Create a statement
            Statement statement = connection.createStatement();

            // Create tables if not exists
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Angestellter (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Vorname TEXT, Nachname TEXT, Plz TEXT, Ort TEXT, Strasse TEXT, Eintrittsdatum DATETIME DEFAULT CURRENT_DATE)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS StudentischeHilfskraft (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Vorname TEXT, Nachname TEXT, Plz TEXT, Ort TEXT, Strasse TEXT, Matrikelnummer TEXT, BeginnArbeitsvertrag DATETIME DEFAULT CURRENT_DATE, EndeArbeitsvertrag DATETIME DEFAULT CURRENT_DATE, StundenlohnInCent INTEGER DEFAULT " + 1200 + ")");

            // Insert data
            CrudAngestellter crud = new CrudAngestellter();

            /** Example insert
            Angestellter a = new Angestellter();
            // Eintringsdatum as Date
            a.Eintrittsdatum = new Date(System.currentTimeMillis());
            a.Vorname = "Max";
            a.Nachname = "Mustermann";
            a.Plz = "12345";
            a.Ort = "Musterstadt";
            a.Strasse = "Musterstraße 1";

            CrudAngestellter crud = new CrudAngestellter();
            crud.create(a);
             **/
            // statement.executeUpdate("INSERT INTO Angestellter VALUES ('Max', 'Mustermann', '12345', 'Musterstadt', 'Musterstraße 1')");


            //Angestellter Max = crud.read(1);
            //System.out.println(Max.Vorname + " " + Max.Nachname + " " + Max.Plz + " " + Max.Ort + " " + Max.Strasse + " " + Max.Eintrittsdatum);

            try {
                printMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.close(connection);
        }
    }
}