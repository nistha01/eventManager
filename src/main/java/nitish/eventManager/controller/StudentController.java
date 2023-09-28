package nitish.eventManager.controller;

import jakarta.persistence.Id;
import nitish.eventManager.model.Department;
import nitish.eventManager.model.Student;
import nitish.eventManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("department/id/{id}/{department}")
    public String updateStudentById(@PathVariable Long id, @PathVariable Department department){
        return studentService.updateStudentById(id,department);
    }
    @DeleteMapping("students/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }
    @GetMapping("students")
    public List<Student> getAllStudent(){
        return studentService.getStudents();
    }
    @GetMapping("get/by/id/{id}")
    public Student getStudent(Long id){
        return studentService.getStudent(id);
    }


}
