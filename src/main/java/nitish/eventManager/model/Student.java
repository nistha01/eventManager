package nitish.eventManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
     @Id
    private Long  StudentId;
//    @Pattern(regexp ="^[A-Z][a-zA-Z]*$\n")
    private String firstName;
    private String lastName;
    @Min(18)@Max(25)
    private Integer age;
    private Department department;
}
