package com.example.calendar_app.repositories;

import com.example.calendar_app.entity.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
public class EventRepository implements ProtoRepository<Event> {
    private Map<String, Event> events = new HashMap<>();

    @Override
    public Event add(Event event) {
        events.put(event.getName(), event);
        System.out.println(events);
        return event;
    }

    @Override
    public void deleteAll() {
        events.clear();
    }

    @Override
    public ArrayList<Event> findAll() {
        return new ArrayList<>(events.values());
    }

    @Override
    public Optional<Event> findNyName(String name) {
        return Optional.ofNullable(events.get(name));
    }

    @Override
    public void deleteByDescription(String description) {
        List<Event> filteredEvents = events
                .values()
                .stream()
                .filter(event -> !Objects.equals(event.getDescription(), description)).toList();
        events.clear();
        filteredEvents.forEach(event -> events.put(event.getDescription(), event));
    }

    @Override
    public Event getByNumber(Integer number) {
        List<Event> list = new ArrayList<>(events.values());
        return list.get(number);
    }
}

