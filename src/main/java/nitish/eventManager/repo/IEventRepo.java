package nitish.eventManager.repo;

import nitish.eventManager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface IEventRepo extends CrudRepository<Event,Long> {
    List<Event> findEventByDate(LocalDate date);
}
