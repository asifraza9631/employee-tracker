package com.fission.lab.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fission.lab.model.CourseType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {


    private String courseName;


    private String courseDuration;


    private String courseTiming;


    private String courseFacultyName;


    private CourseType  courseType;



}
