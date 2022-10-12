# Software Engineering

> Als Grundlage zu dieser Entscheidung muss jeder Student bzw. jede Projektgruppe zu jedem Thema eine
> Projektbeschreibung vorlegen. Sie besteht aus einem Projekttitel, einer kurzen Skizze (3-4 Sätze), einer
> kurzen Beschreibung des Projekthintergrundes zur Einordnung des Themas und eine genauere
> Beschreibung der wesentlichen Projektinhalte (Umfang insgesamt ca. 1-2 DinA4-Seiten).

# Studiprojektverwaltungssoftware - Software Engineering WS22/23

Im Rahmen des Studiums bearbeiten Studenten mehrere Projekte im Bereich der Informatik. Diese Projekte dürften sich die Studenten zum Großteil selbst aussuchen, müssen jedoch Ihren Projektvorschlag vorher von den Mitarbeitern der Fachhochschule absegnen lassen. Um diese Arbeit den Mitarbeitern leichter zu gestalten, entwickeln wir eine Verwaltungssoftware.

## Funktionen

Die Software soll folgende Funktionen umsetzen:

### Projektverwaltung
1. Studenten und Mitarbeiter loggen sich mit FH-Login (LDAP?) ein.
2. Erstellung eines Projekteantrags durch einen Studenten für Modul X.
3. Der Projektantrag wird als Markdown geschrieben und eingereicht.
4. Der Projektantrag beinhaltet folgende Attribute
     1. Titel
     2. Projektbeschreibung kurz (3-4 Sätze)
     3. Ausführliche Projektbeschreibung
     4. Vorschlag für Deadline
     5. Matrikelnummern der Projektmitglieder (bis zu 3 Stück)
     6. Emailadressen der Projektmitglieder
5. Ein Mitarbeiter der Fachhochschule kann den Antrag annehmen oder ablehnen.
6. Ein Mitarbeiter kann den Antrag kommentieren.
7. Ein Mitarbeiter kann die Projektattribute ändern.
8. Bei Events 5 bis 7 wird eine E-Mail an den Studenten versendet.
9.  Terminierungsfunktion für die Projektvorstellung.
10. Ansprechpartner von fremden Unternehmen zuweisen können (mit Eintragung dessen Email)
11. Studenten können alle Aspekte das Projektes ändern (Titel, Beschreibung, Deadline, etc.)
12. Studenten können die Projektmitglieder ändern.
13. Wenn ein Student ein Projekt anlegt, wird er automatisch als Projektmitglied hinzugefügt.
14. Mitarbeiter können die Projektmitglieder ändern.
15. Rollenvergabe für die Projektmitglieder (Projektleiter, Projektmitglied, etc.)
16. Rollenvergabe für die Mitarbeiter (Projektbetreuer, Abnahmeprüfer, etc.)
  


### UI
1. Die Eintragungen von Projekten sollen in einer ListView dargestellt werden. Nicht einzelne Zeile, sondern mehrere, um alle wichtigen Informationen (Projektname, Kurzbeschreibung, Studenten, Ansprechpartner, Deadline, nächster Termin, Approved) anzuzeigen
2. Module via TreeView
    + WS22/23
      + Modul 1
      + Modul 2
      + Modul 3
    + SS24
      + Modul 1
      + Modul 2

### Meta
13. Überall Erreichbar (als Website, damit der Anwender nach Praktikas/Vorlesungen "schnell nebenbei" Änderungen eintragen kann)
14. WebPush Notifications
16. Calender Subscriptions (CalDav / .ics => https://en.wikipedia.org/wiki/ICalendar)
17. Canceln eines Termins vom Mitarbeiter via iCalendar
18. Schicken des Termins an die Studenten via iCalendar & Emailbestätigung
19. Studenten bekommen per E-Mail einen einzigartigen Link, über dessen sie y/n zu einem Termin sagen können
20. Offene API für externe Anwendungen
21. RBAC / ACL damit nur die Mitarbeiter, die mit einem jeweiligen Modul zu tun haben, Zugriff auf die Daten haben


## UI

![UI](dia.png)