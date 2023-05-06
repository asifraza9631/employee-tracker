package com.fission.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_posts")
@Data
@JsonIgnoreProperties({"comments"})
@ToString(exclude = "comments")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    private String description;
    private String content;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    List<Comment> comments = new ArrayList<>();
}
