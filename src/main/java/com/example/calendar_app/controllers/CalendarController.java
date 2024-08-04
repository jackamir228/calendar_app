package com.example.calendar_app.controllers;

import com.example.calendar_app.dto.EventDto;
import com.example.calendar_app.entity.Event;
import com.example.calendar_app.servises.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("calendar")
public class CalendarController {
    private final EventService eventService;

    @Autowired
    public CalendarController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping()
    public List<Event> get() {
        return eventService.getEvents();
    }

    @GetMapping("/{number}")
    public Event getByNumber(@PathVariable Integer number) {
        return eventService.getByNumber(number);
    }


    @PostMapping
    public ResponseEntity create(@RequestBody EventDto body) {
        eventService.create(body);
       return ResponseEntity.status(201).body("создан объект");
    }

    @DeleteMapping
    public void delete(@RequestParam(required = false) String description) {
        if (description == null) {
            eventService.deleteAll();
        }
        eventService.deleteByDescription(description);
    }
}
