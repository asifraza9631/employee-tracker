package com.fission.lab.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Table(name = "instructor")
@Entity
@Data
public class Instructor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instructor")
    @JsonManagedReference
    private InstructorDetail instructorDetail;

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        if (instructorDetail != null) {
            instructorDetail.setInstructor(this);
        }
        this.instructorDetail = instructorDetail;
    }


}
