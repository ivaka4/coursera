package com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentCourseKey implements Serializable {

    @Column(name = "student_id", columnDefinition = "nchar(10)")
    String studentId;

    @Column(name = "course_id")
    Integer courseId;
}
