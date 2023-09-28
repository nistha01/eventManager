package nitish.eventManager.service;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nitish.eventManager.model.Student;
import nitish.eventManager.model.Department;
import nitish.eventManager.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;

    public String addStudent(Student student) {
        iStudentRepo.save(student);
        return "Student Added";
    }

    public String updateStudentById(Long id, Department department) {
    Student tempId= iStudentRepo.findById(id).orElse(null);
       if(tempId!=null){
           tempId.setDepartment(department);
           return "Department updated";
       }
       return "Invalid Id";
    }

    public String deleteStudentById(Long id) {
        Student presentStd=iStudentRepo.findById(id).orElse(null);
        if(presentStd!=null) {
            iStudentRepo.deleteById(id);
            return "student deleted";
        }
        return "invalid id";
    }

    public List<Student> getStudents() {
        return (List<Student>) iStudentRepo.findAll();
    }

    public Student getStudent(Long id) {
        return iStudentRepo.findById(id).get();
    }
}
