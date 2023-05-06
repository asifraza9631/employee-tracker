package com.fission.lab.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "instructor_detail")
@Entity
@Data
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

      @OneToOne
      @JoinColumn(name = "instructor_id")
      @JsonBackReference
     private  Instructor instructor;


}
