package com.fission.lab.service;


import com.fission.lab.dto.CourseDTO;
import com.fission.lab.dto.CourseTypeDTO;
import com.fission.lab.model.Course;
import com.fission.lab.model.CourseType;
import com.fission.lab.repository.CourseRepository;
import com.fission.lab.repository.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseTypeService {

           @Autowired
            private CourseRepository courseRepository;

            @Autowired
            private CourseTypeRepository courseTypeRepository;



    public String saveCourseType(CourseTypeDTO courseTypeDTO)
        {
             CourseType ctype = new CourseType();


                        CourseTypeDTO courseTypeDTO1 = new CourseTypeDTO();


            ctype.setCourseFee(courseTypeDTO.getCourseFee());
            ctype.setCourseTypeName(courseTypeDTO.getCourseTypeName());

                        List<CourseDTO>  courseDTOList = courseTypeDTO.getCourses();

                        Course course = new Course();
                        List<Course> courses = new ArrayList<>();

                        for( CourseDTO courseDTO : courseDTOList)
                        {
                            Course course1 = new Course();

                            course1.setCourseName(courseDTO.getCourseName());
                            course1.setCourseTiming(courseDTO.getCourseTiming());
                            course1.setCourseFacultyName(courseDTO.getCourseFacultyName());
                           course1.setCourseDuration(courseDTO.getCourseDuration());
                           course1.setCourseType(ctype);
                            courses.add(course1);


                        }

                        ctype.setCourses(courses);

                        courseTypeRepository.save(ctype);

                        return  "saved";

        }


}
