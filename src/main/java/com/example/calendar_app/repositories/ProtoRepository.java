package com.example.calendar_app.repositories;

import com.example.calendar_app.entity.Event;

import java.util.ArrayList;
import java.util.Optional;

public interface ProtoRepository<E> {
    E add(E e);
    ArrayList<E> findAll();
    Optional <E> findNyName(String name);
    void deleteAll();
    void deleteByDescription(String description);

    Event getByNumber(Integer number);

}
