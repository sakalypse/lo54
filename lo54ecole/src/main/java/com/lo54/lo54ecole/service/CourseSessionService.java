package com.lo54.lo54ecole.service;

import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.repository.CourseSessionDAO;

public class CourseSessionService {
    public CourseSession getCourseSessionById(int id){
        CourseSessionDAO csDao = new CourseSessionDAO();
        return csDao.GetById(id);
    }

    public void saveCourseSession(CourseSession cs){
        CourseSessionDAO csDao = new CourseSessionDAO();
        csDao.Save(cs);
    }
}
