package de.fhswf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CrudStudentischeHilfskraft implements Crud<StudentischeHilfskraft> {
    @Override
    public void create(StudentischeHilfskraft studentischeHilfskraft) {
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            Integer affectedRows = stmt.executeUpdate("INSERT INTO StudentischeHilfskraft VALUES (null, '" + studentischeHilfskraft.Vorname + "', '" + studentischeHilfskraft.Nachname + "', '" + studentischeHilfskraft.Plz + "', '" + studentischeHilfskraft.Ort + "', '" + studentischeHilfskraft.Strasse + "', '" + studentischeHilfskraft.Matrikelnummer + "', '" + new SimpleDateFormat("YYYY-MM-DD").format(studentischeHilfskraft.BeginnArbeitsvertrag) + "', '" + new SimpleDateFormat("YYYY-MM-DD").format(studentischeHilfskraft.EndeArbeitsvertrag) + "', '" + StudentischeHilfskraft.StandardStundenlohnInCent + "')");
            if (affectedRows == 1) {
                System.out.println("Studentische Hilfskraft wurde erfolgreich angelegt.");
            } else {
                System.out.println("Studentische Hilfskraft konnte nicht angelegt werden.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<StudentischeHilfskraft> readAll() {
        Connection conn = ConnectionFactory.getConnection();
        List<StudentischeHilfskraft> studentischeHilfskraefte = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM StudentischeHilfskraft");
            while (rs.next()) {
                StudentischeHilfskraft studentischeHilfskraft = new StudentischeHilfskraft();
                studentischeHilfskraft.Id = rs.getInt("id");
                studentischeHilfskraft.Vorname = rs.getString("Vorname");
                studentischeHilfskraft.Nachname = rs.getString("Nachname");
                studentischeHilfskraft.Plz = rs.getString("Plz");
                studentischeHilfskraft.Ort = rs.getString("Ort");
                studentischeHilfskraft.Strasse = rs.getString("Strasse");
                studentischeHilfskraft.Matrikelnummer = rs.getString("Matrikelnummer");

                try {
                    studentischeHilfskraft.BeginnArbeitsvertrag = df.parse(rs.getString("BeginnArbeitsvertrag"));
                    studentischeHilfskraft.EndeArbeitsvertrag = df.parse(rs.getString("EndeArbeitsvertrag"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                studentischeHilfskraft.StundenlohnInCent = rs.getInt("StundenlohnInCent");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentischeHilfskraefte;
    }

    @Override
    public StudentischeHilfskraft read(int id) {
        Connection conn = ConnectionFactory.getConnection();
        StudentischeHilfskraft studentischeHilfskraft = new StudentischeHilfskraft();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM StudentischeHilfskraft WHERE id = " + id);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (rs.next()) {
                studentischeHilfskraft.Id = rs.getInt("id");
                studentischeHilfskraft.Vorname = rs.getString("Vorname");
                studentischeHilfskraft.Nachname = rs.getString("Nachname");
                studentischeHilfskraft.Plz = rs.getString("Plz");
                studentischeHilfskraft.Ort = rs.getString("Ort");
                studentischeHilfskraft.Strasse = rs.getString("Strasse");
                studentischeHilfskraft.Matrikelnummer = rs.getString("Matrikelnummer");

                try {
                        studentischeHilfskraft.BeginnArbeitsvertrag = df.parse(rs.getString("BeginnArbeitsvertrag"));
                        studentischeHilfskraft.EndeArbeitsvertrag = df.parse(rs.getString("EndeArbeitsvertrag"));

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                studentischeHilfskraft.StundenlohnInCent = rs.getInt("StundenlohnInCent");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentischeHilfskraft;
    }

    @Override
    public void update(int id, StudentischeHilfskraft studentischeHilfskraft) {
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            Integer affectedRows = stmt.executeUpdate("UPDATE StudentischeHilfskraft SET Vorname = '" + studentischeHilfskraft.Vorname + "', Nachname = '" + studentischeHilfskraft.Nachname + "', Plz = '" + studentischeHilfskraft.Plz + "', Ort = '" + studentischeHilfskraft.Ort + "', Strasse = '" + studentischeHilfskraft.Strasse + "', Matrikelnummer = '" + studentischeHilfskraft.Matrikelnummer + "', BeginnArbeitsvertrag = '" + new SimpleDateFormat("YYYY-MM-DD").format(studentischeHilfskraft.BeginnArbeitsvertrag) + "', EndeArbeitsvertrag = '" + new SimpleDateFormat("YYYY-MM-DD").format(studentischeHilfskraft.EndeArbeitsvertrag) + "', StundenlohnInCent = '" + studentischeHilfskraft.StundenlohnInCent + "' WHERE id = " + id);
            if (affectedRows == 1) {
                System.out.println("Studentische Hilfskraft wurde erfolgreich aktualisiert.");
            } else {
                System.out.println("Studentische Hilfskraft konnte nicht aktualisiert werden.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            Integer affectedRows = stmt.executeUpdate("DELETE FROM StudentischeHilfskraft WHERE id = " + id);
            if (affectedRows == 1) {
                System.out.println("Studentische Hilfskraft wurde erfolgreich gelöscht.");
            } else {
                System.out.println("Studentische Hilfskraft konnte nicht gelöscht werden.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
