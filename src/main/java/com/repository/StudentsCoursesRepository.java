package com.repository;

import com.entity.StudentCourses;
import com.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsCoursesRepository extends JpaRepository<StudentCourses, Integer> {

}
