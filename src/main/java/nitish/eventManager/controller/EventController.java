package nitish.eventManager.controller;

import nitish.eventManager.model.Event;
import nitish.eventManager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.ListDataEvent;
import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;
    @PostMapping("event")
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }
    @GetMapping("allEvents")
    public List<Event> getAllEvent(){
        return eventService.getAllEvent();
    }
    @PutMapping("event/{id}")
    public String updateEvent(@PathVariable Long id,@RequestBody Event event){
        return eventService.updateEvent(id,event);
    }
    @DeleteMapping("event/by/id/{id}")
    public String deleteEventById(Long id){
        return eventService.deleteEventById(id);
    }
    @GetMapping("events/by/date/{date}")
    public List<Event> getEventsByDate(@PathVariable LocalDate date){
        return eventService.findEventByDate(date);
    }
}
