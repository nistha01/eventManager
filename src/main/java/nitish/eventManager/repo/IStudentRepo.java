package nitish.eventManager.repo;

import nitish.eventManager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepo extends CrudRepository<Student,Long> {

}
