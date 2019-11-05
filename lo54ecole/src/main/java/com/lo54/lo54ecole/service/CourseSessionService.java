package com.lo54.lo54ecole.service;

import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.repository.CourseSessionDAO;

import java.util.List;

public class CourseSessionService {
    public CourseSession getCourseSessionById(int id){
        CourseSessionDAO csDao = new CourseSessionDAO();
        return csDao.GetById(id);
    }

    //TODO :
    public List<CourseSession> getCourseSessionByTitle(String title){
        CourseSessionDAO csDao = new CourseSessionDAO();
        return null;
    }

    public List<CourseSession> getCourseSessionByDate(String date){
        CourseSessionDAO csDao = new CourseSessionDAO();
        return null;
    }

    public List<CourseSession> getCourseSessionByLocation(String location){
        CourseSessionDAO csDao = new CourseSessionDAO();
        return null;
    }

    public List<CourseSession> getAll(){
        CourseSessionDAO csDao = new CourseSessionDAO();
        return csDao.getAll();
    }

    public void saveCourseSession(CourseSession cs){
        CourseSessionDAO csDao = new CourseSessionDAO();
        csDao.Save(cs);
    }
}
