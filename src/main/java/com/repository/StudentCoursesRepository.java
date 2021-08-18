package com.repository;

import com.entity.StudentCourses;
import com.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses, Integer> {

    @Query("SELECT s.student.firstName, s.student.lastName, s.course.credit FROM StudentCourses s WHERE s.course.credit > ?1")
    List<StudentCourses> getStudentsByRequiredCredit(int credit);

}
