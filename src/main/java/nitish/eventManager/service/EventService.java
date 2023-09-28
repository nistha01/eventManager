package nitish.eventManager.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nitish.eventManager.model.Event;
import nitish.eventManager.repo.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class EventService {
    @Autowired
    IEventRepo iEventRepo;

    public String addEvent(Event event) {
        iEventRepo.save(event);
        return "event added";
    }

    public String updateEvent(Long id, Event event) {
        Event ev=iEventRepo.findById(id).orElse(null);
        if(ev!=null){
            ev.setEventName(event.getEventName());
            ev.setLocationOfEvent(event.getLocationOfEvent());
            ev.setDate(event.getDate());
            ev.setStartTime(event.getStartTime());
            ev.setEndTime(event.getEndTime());
            ev.setEventId(event.getEventId());
            return "Event details updated";
        }
        return "invalid Event Id";
    }

    public String deleteEventById(Long id) {
        Event ev= iEventRepo.findById(id).orElse(null);
        if(ev!=null){
        iEventRepo.deleteById(id);
        return "deleted";
        }
        return "invalid id";
    }

    public List<Event> findEventByDate(LocalDate date) {
       return iEventRepo.findEventByDate(date);
    }

    public List<Event> getAllEvent() {
        return (List<Event>) iEventRepo.findAll();
    }
}
