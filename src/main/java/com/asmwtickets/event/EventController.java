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
@CrossOrigin
public class EventController {

    private final EventRepository repository;

    @Autowired
    public EventController(EventRepository repository) {
        this.repository = repository;
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

    @GetMapping("/event/{name}")
    public Event getEventByName(@PathVariable String name) {
        return repository.findByName(name);
    }
}
