package com.service.impl;

import com.entity.StudentCourses;
import com.google.gson.Gson;
import com.misc.parsers.HtmlWriter;
import com.repository.StudentsCoursesRepository;
import com.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private final StudentsCoursesRepository studentCourses;
    private final HtmlWriter htmlWriter;
    private final Gson gson;

    public ReportServiceImpl(StudentsCoursesRepository studentCourses, HtmlWriter htmlWriter, Gson gson) {
        this.studentCourses = studentCourses;
        this.htmlWriter = htmlWriter;
        this.gson = gson;
    }


    @Override
    public void report(String path) {
        List<StudentCourses> students = this.studentCourses.findAll();
        htmlWriter.saveToFile(gson.toJson(students), "report", path);
    }
}
