package com.fission.lab.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course_type")
@Data
public class CourseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_type_id")
    private Long courseTypeId;

    @Column(name = "course_type_name")
    private String courseTypeName;

    @Column(name = "course_fee")
    private Double courseFee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseType")
    private List<Course> courses=new ArrayList<>();

}