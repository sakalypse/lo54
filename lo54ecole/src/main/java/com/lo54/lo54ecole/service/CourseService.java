package com.lo54.lo54ecole.service;

import com.lo54.lo54ecole.entity.Course;
import com.lo54.lo54ecole.repository.CourseDAO;

public class CourseService {
    public Course getCourseByTitle(String title){
        CourseDAO courseDAO = new CourseDAO();
        return courseDAO.GetByTitle(title);
    }

    public void saveCourse(Course c){
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.Save(c);
    }
}
