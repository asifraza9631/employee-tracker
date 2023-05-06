package com.fission.lab.repository;

import com.fission.lab.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository  extends JpaRepository<Instructor, Long> {
}
