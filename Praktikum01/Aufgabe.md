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
- Erstellung eines Projektes
- Zuweisung des Projektes zu einem Modul
- bis zu drei Studenten zu einem Projekt zuweisen (inklusive Matrikelnr + email)
- Projektbeschreibung (kurz)
- Projektbeschreibung lang
- Deadline
- Ist das Projekt vom Mitarbeiter zugelassen worden (y/n)
- Terminierungsfunktion für 2 Vorträge zum Thema. => Mitarbeiter kann verschiedene Zeiträume festlegen, an dem er könnte. Die Studenten können dann zu diesen Terminen y/n sagen.
- Ansprechpartner von fremden Unternehmen zuweisen können (mit Eintragung dessen Email)


### UI
- Die Eintragungen von Projekten sollen in einer ListView dargestellt werden. Nicht einzelne Zeile, sondern mehrere, um alle wichtigen Informationen (Projektname, Kurzbeschreibung, Studenten, Ansprechpartner, Deadline, nächster Termin, Approved) anzuzeigen
- Module via TreeView
    + WS22/23
      + Modul 1
      + Modul 2
      + Modul 3
    + SS24
      + Modul 1
      + Modul 2

### Meta
- Überall Erreichbar (als Website, damit der Anwender nach Praktikas/Vorlesungen "schnell nebenbei" Änderungen eintragen kann)
- WebPush Notifications
- Loginmaske für Mitarbeiter (Loginsystem der FH, falls das mitteilt ob die Person Lehrkraft ist, oder nicht. LDAP? OAuth? Ich weiß nicht, was die FH verwendet.)
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