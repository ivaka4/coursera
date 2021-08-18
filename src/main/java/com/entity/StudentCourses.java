package com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentCourses {

    @EmbeddedId
    private StudentCourseKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Students student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Courses course;


    @Column(name = "completionDate")
    private LocalDate completionDate;
}
