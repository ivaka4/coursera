package com.repository;

import com.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {
    Optional<Courses> getCoursesByCredit(int credit);
}
