package com.service.impl;

import com.entity.StudentCourses;
import com.google.gson.Gson;
import com.misc.parsers.JsonWriter;
import com.repository.StudentsCoursesRepository;
import com.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private final StudentsCoursesRepository studentCourses;
    private final JsonWriter jsonWriter;
    private final Gson gson;

    public ReportServiceImpl(StudentsCoursesRepository studentCourses, JsonWriter jsonWriter, Gson gson) {
        this.studentCourses = studentCourses;
        this.jsonWriter = jsonWriter;
        this.gson = gson;
    }


    @Override
    public void report(String path) {
        List<StudentCourses> students = this.studentCourses.findAll();
        jsonWriter.saveToFile(gson.toJson(students), "report", path);
    }
}
