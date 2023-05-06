package com.fission.lab.controller;

import com.fission.lab.dto.CourseTypeDTO;
import com.fission.lab.model.*;
import com.fission.lab.repository.CourseRepository;
import com.fission.lab.repository.CourseTypeRepository;
import com.fission.lab.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MyCourseController {


      @Autowired
     private CourseTypeRepository courseTypeRepository;

       @Autowired
        private CourseRepository courseRepository;

        @Autowired
        private CourseTypeService courseTypeService;

    @PostMapping("/course")
    public CourseType saveCourseType(@RequestBody CourseType courseType) {

          CourseType courseType1 = new CourseType();
          courseType1.setCourseFee(courseType.getCourseFee());
          courseType1.setCourseTypeName(courseType.getCourseTypeName());
           List<Course> courses =  courseType.getCourses();
        List<Course> newCourses = new ArrayList<>();

           for(Course course: courses)
           {
                       Course c = new Course();
                       c.setCourseName(course.getCourseName());
                       c.setCourseTiming(course.getCourseTiming());
                       c.setCourseType(course.getCourseType());
                       c.setCourseDuration(course.getCourseDuration());
                       c.setCourseFacultyName(course.getCourseFacultyName());
                       c.setCourseType(courseType1);
               newCourses.add(c);

           }
           courseType1.setCourses(newCourses);

              return  courseTypeRepository.save(courseType1);
          }


    @PostMapping("/courseDTO")
          public String saveCourseType(@RequestBody CourseTypeDTO courseTypeDTO)
          {
                              courseTypeService.saveCourseType(courseTypeDTO);
                              return  "save successfully";
          }

}
