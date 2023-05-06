package com.fission.lab.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "course")
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_duration")
    private String courseDuration;

    @Column(name = "course_timing")
    private String courseTiming;

    @Column(name = "course_faculty_name")
    private String courseFacultyName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_type_id")
    @JsonIgnore
    private CourseType courseType;
}
