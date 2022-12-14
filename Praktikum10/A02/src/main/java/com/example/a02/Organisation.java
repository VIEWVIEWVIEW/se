package com.example.a02;

import jakarta.persistence.*;

@Entity
@Table(name = "organisation")
public class Organisation {

    @Column(unique=true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organisation(String name) {
        this.name = name;
    }

    public Organisation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}