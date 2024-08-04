package com.example.calendar_app.servises;

import com.example.calendar_app.dto.EventDto;
import com.example.calendar_app.entity.Event;

import java.util.List;

public interface ProtoService<E> {
    E create(EventDto eventDto);

    List<E> getEvents();

    void deleteByDescription(String description);

    void deleteAll();

    Event getByNumber(Integer number);
}
