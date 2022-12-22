package com.example.a02;

import java.time.LocalDate;
import java.util.List;

public class Projekt {
    private Ansprechpartner ansprechpartner;
    private String titel;
    private String beschreibung;
    private Projektstatus status;

    private List<Student> studenten;
    private Organisation organisation;

    private LocalDate termin1;
    private LocalDate termin2;

    public LocalDate getTermin1() {
        return termin1;
    }

    public void setTermin1(LocalDate termin1) {
        this.termin1 = termin1;
    }

    public LocalDate getTermin2() {
        return termin2;
    }

    public void setTermin2(LocalDate termin2) {
        this.termin2 = termin2;
    }

    public List<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(List<Student> studenten) {
        this.studenten = studenten;
    }

    public Projekt(String titel, String beschreibung, Projektstatus status, List<Student> studenten, Organisation organisation, Ansprechpartner ansprechpartner) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.ansprechpartner = ansprechpartner;
        this.studenten = studenten;
        this.organisation = organisation;
    }

    public Projekt() {
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
    }

    public Ansprechpartner getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(Ansprechpartner ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public Projektstatus getStatus() {
        return status;
    }

    public void setStatus(Projektstatus status) {
        this.status = status;
    }









    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
}
