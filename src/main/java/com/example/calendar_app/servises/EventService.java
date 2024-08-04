package com.example.calendar_app.servises;

import com.example.calendar_app.dto.EventDto;
import com.example.calendar_app.entity.Event;
import com.example.calendar_app.repositories.EventRepository;
import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class EventService implements ProtoService<Event> {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event create(EventDto body) {

        LocalDate date = body.date() == null ? LocalDate.now() : body.date();
        String name = body.name() == null ? "Без названия" : body.name();
        String description = body.description() == null ? "Без описания" : body.description();

        Event event = Event.builder()
                .name(name)
                .description(description)
                .date(date)
                .build();
        eventRepository.add(event);
        log.info("event has been created", event);
        return event;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteByDescription(String description) {
        eventRepository.deleteByDescription(description);
    }

    @Override
    public void deleteAll() {
        eventRepository.deleteAll();
    }

    @Override
    public Event getByNumber(Integer number) {
        return eventRepository.getByNumber(number);
    }
}
