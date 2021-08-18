package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "total_time")
    private int totalTime;

    @Column(nullable = false)
    private int credit;

    @Column(name = "time_created", nullable = false)
    private LocalDateTime timeCreated;

    @ManyToOne
    @JoinColumn(name = "instructor_id",referencedColumnName = "id")
    private Instructors instructors;

    @OneToMany(mappedBy = "course")
    private Set<StudentCourses> sc;
}
