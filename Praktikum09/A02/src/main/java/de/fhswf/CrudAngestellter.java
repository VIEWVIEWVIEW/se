package de.fhswf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class CrudAngestellter implements Crud<Angestellter> {

    @Override
    public void create(Angestellter t) {
        // Get connection
        Connection conn = ConnectionFactory.getConnection();
        try {
            // Create statement
            Statement stmt = conn.createStatement();
            // Execute statement
            Integer affectedRows = stmt.executeUpdate("INSERT INTO Angestellter VALUES (null, '" + t.Vorname + "', '" + t.Nachname + "', '" + t.Plz + "', '" + t.Ort + "', '" + t.Strasse +   "', '" + new SimpleDateFormat("YYYY-MM-DD").format(t.Eintrittsdatum) + "')");
            if (affectedRows == 1) {
                System.out.println("Angestellter wurde erfolgreich angelegt.");
            } else {
                System.out.println("Angestellter konnte nicht angelegt werden.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Angestellter> readAll() {
        Connection conn = ConnectionFactory.getConnection();
        List<Angestellter> angestellte = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Angestellter");
            while (rs.next()) {
                Angestellter a = new Angestellter();
                a.Id = rs.getInt("id");
                a.Vorname = rs.getString("Vorname");
                a.Nachname = rs.getString("Nachname");
                a.Plz = rs.getString("Plz");
                a.Ort = rs.getString("Ort");
                a.Strasse = rs.getString("Strasse");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                a.Eintrittsdatum = df.parse(rs.getString("Eintrittsdatum"));
                angestellte.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return angestellte;
    }

    @Override
    public Angestellter read(int id) {
        Connection conn = ConnectionFactory.getConnection();
        Angestellter a = new Angestellter();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Angestellter WHERE id = " + id);
            while (rs.next()) {
                a.Id = rs.getInt("id");
                a.Vorname = rs.getString("Vorname");
                a.Nachname = rs.getString("Nachname");
                a.Plz = rs.getString("Plz");
                a.Ort = rs.getString("Ort");
                a.Strasse = rs.getString("Strasse");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                a.Eintrittsdatum = df.parse(rs.getString("Eintrittsdatum"));
            }
            return a;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Angestellter();
    }

    @Override
    public void update(int id, Angestellter t) {
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            Integer affectedRows = stmt.executeUpdate("UPDATE Angestellter SET Vorname = '" + t.Vorname + "', Nachname = '" + t.Nachname + "', Plz = '" + t.Plz + "', Ort = '" + t.Ort + "', Strasse = '" + t.Strasse + "', Eintrittsdatum = '" + new SimpleDateFormat("YYYY-MM-DD").format(t.Eintrittsdatum) + "' WHERE id = " + id);
            if (affectedRows == 1) {
                System.out.println("Angestellter wurde erfolgreich aktualisiert.");
            } else {
                System.out.println("Angestellter konnte nicht aktualisiert werden.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            Integer affectedRows = stmt.executeUpdate("DELETE FROM Angestellter WHERE id = " + id);
            if (affectedRows == 1) {
                System.out.println("Angestellter wurde erfolgreich gelöscht.");
            } else {
                System.out.println("Angestellter konnte nicht gelöscht werden.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

