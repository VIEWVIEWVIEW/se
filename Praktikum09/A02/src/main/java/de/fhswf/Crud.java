package de.fhswf;

import java.util.List;


public interface Crud<T> {
     void create(T t);
     List<T> readAll();
     T read(int id);
     void update(int id, T t);
     void delete(int id);
}
