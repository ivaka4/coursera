package com.service.impl;


import com.entity.Courses;
import com.entity.StudentCourses;
import com.entity.Students;
import com.repository.CourseRepository;
import com.repository.StudentRepository;
import com.repository.StudentCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements com.service.StudentService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final StudentCoursesRepository studentCoursesRepository;

    @Autowired
    public StudentService(CourseRepository courseRepository, StudentRepository studentRepository, StudentCoursesRepository studentCoursesRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.studentCoursesRepository = studentCoursesRepository;
    }

    @Override
    public void getStudentByRequiredCredits(int credits) {
        List<StudentCourses> studentCourses = this.studentCoursesRepository.getStudentsByRequiredCredit(credits);

    }
}
