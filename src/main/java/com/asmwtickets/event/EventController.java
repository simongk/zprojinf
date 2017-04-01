package com.asmwtickets.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Szymon Gasienica-Kotelnicki
 * 2017-04-01
 */
@RestController
@RequestMapping("/event")
public class EventController {

    private final EventRepository repository;

    @Autowired
    public EventController(EventRepository repository) {
        this.repository = repository;
    }

    @RequestMapping()
    public void addToDatabase() {
        Event e = new Event();
        e.setName("Spring Boot Workshop");
        e.setLocation("Internet");
        Event e2 = new Event();
        e2.setName("Gowno");
        e2.setLocation("Kibel");
        repository.save(e);
        repository.save(e2);
    }


    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        repository.delete(id);
    }


    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event){
        return repository.save(event);
    }

    @PutMapping("/update/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event){
        Event newEvent = repository.findOne(id);
        newEvent.setName(event.getName());
        newEvent.setLocation(event.getLocation());
        return repository.save(newEvent);
    }

    public Event getEventByName(String name) {
        return repository.findByName(name);
    }
}
