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
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Students{

    @Id
    @Column(columnDefinition = "nchar(10)")
    private String pin;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "time_created", nullable = false)
    private LocalDateTime timeCreated;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<StudentCourses> sc;

}
