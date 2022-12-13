package com.example.a02;

import jakarta.persistence.EntityManager;

public class EntityManagerFactorySingleton {
    EntityManager entityManager;

    private static EntityManagerFactorySingleton instance;

    private EntityManagerFactorySingleton() {
        entityManager = jakarta.persistence.Persistence.createEntityManagerFactory("projektverwaltung").createEntityManager();
    }

    public static EntityManager getEntityManager() {
        if (instance == null) {
            instance = new EntityManagerFactorySingleton();
        }
        return instance.entityManager;
    }

}
