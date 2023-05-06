package com.fission.lab.dto;

import com.fission.lab.model.Course;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseTypeDTO {


    private String courseTypeName;


    private Double courseFee;

    private List<CourseDTO> courses=new ArrayList<>();

}
