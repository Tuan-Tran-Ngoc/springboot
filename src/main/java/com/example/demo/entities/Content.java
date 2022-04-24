package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coursecontents")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private int content_id;

    @Column(name = "content")
    private String content;

    @ManyToMany(mappedBy = "contents")
    @JsonIgnore
    private Set<Course> courses =  new HashSet<>();
//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinTable(name = "course_coursecontents_mapping",
//            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id")   ,
//            joinColumns = @JoinColumn(name = "content_id", referencedColumnName = "content_id"))
//    private Set<Course> courses =  new HashSet<>();

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
