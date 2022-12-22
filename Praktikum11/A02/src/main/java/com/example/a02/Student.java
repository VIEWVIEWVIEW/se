package com.example.a02;

public class Student {
    private String name;
    private String vorname;
    private String email;
    private String matrikelnummer;

    public Student(String name, String vorname, String email, String matrikelnummer) {
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.matrikelnummer = matrikelnummer;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(String matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }
}
