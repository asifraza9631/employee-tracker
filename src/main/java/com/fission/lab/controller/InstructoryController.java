package com.fission.lab.controller;

import com.fission.lab.model.Instructor;
import com.fission.lab.repository.InstructorDetailRepository;
import com.fission.lab.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class InstructoryController {

    @Autowired
   private InstructorRepository instructorRepository;

    @Autowired
    private InstructorDetailRepository instructorDetailRepository;


    @PostMapping("/instructors")
    public Instructor createUser(@Validated @RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }


    @GetMapping("/instructors")
    public List<Instructor> getInstructor() {

        List<Instructor> instructor = instructorRepository.findAll();

         return  instructor;
    }


     @GetMapping("/instructors/{id}")
    public Instructor getInstructById( @PathVariable("id") Long id)
    {
          Optional<Instructor> instructorOptional =  instructorRepository.findById(id);
          return  instructorOptional.get();
    }

     @DeleteMapping("/instructors/{id}")
    public  String deleteById(@PathVariable("id") Long id)
    {
           instructorRepository.deleteById(id);

           return  "record deleted successfuly";
    }



}
