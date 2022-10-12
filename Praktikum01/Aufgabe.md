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
1. Student loggt sich mit FH-Login (LDAP?) ein.
2. Mitarbeiter loggt sich ein
3. Erstellung eines Projekteantrags durch einen Studenten für Modul X.
4. Der Projektantrag wird als Markdown geschrieben und eingereicht.
5. Der Projektantrag beinhaltet folgende Attribute
  1. Titel
  2. Projektbeschreibung kurz (3-4 Sätze)
  3. Ausführliche Projektbeschreibung
  4. Vorschlag für Deadline
  5. Matrikelnummern der Projektmitglieder (bis zu 3 Stück)
  6. Emailadressen der Projektmitglieder
6. Ein Mitarbeiter der Fachhochschule kann den Antrag annehmen oder ablehnen.
7. Ein Mitarbeiter kann den Antrag auch kommentieren.
8. Ein Mitarbeiter kann die Projektattribute ändern.
9. Bei Events 5 bis 7 wird eine E-Mail an den Studenten versendet.
10. Terminierungsfunktion für die Projektvorstellung.
11. Ansprechpartner von fremden Unternehmen zuweisen können (mit Eintragung dessen Email)


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
15. Loginmaske für Mitarbeiter (Loginsystem der FH, falls das mitteilt ob die Person Lehrkraft ist, oder nicht. LDAP? OAuth? Ich weiß nicht, was die FH verwendet.)
- Calender Subscriptions (CalDav / .ics => https://en.wikipedia.org/wiki/ICalendar)
- Canceln eines Termins vom Mitarbeiter via iCalendar
- Schicken des Termins an die Studenten via iCalendar & Emailbestätigung
- Studenten bekommen per E-Mail einen einzigartigen Link, über dessen sie y/n zu einem Termin sagen können
- Applikation:
  - Website: Nuxt.js (SSR, damit für Datenbankabfragen nicht noch eine extra API geschrieben werden muss)
  - DB: Prisma 
- RBAC / ACL damit nur die Mitarbeiter, die mit einem jeweiligen Modul zu tun haben, Zugriff auf die Daten haben


## UI

![UI](dia.png)