package com.lo54.lo54ecole.entity;

import java.io.Serializable;
import java.util.Date;

public class CourseSession implements Serializable {

    private long course_session_id;
    private Date start_date;
    private Date end_date;
    private Integer max;
    private String course_code;
    private long location_id;

    public CourseSession() {

    }

    public CourseSession(long course_session_id, Date start_date, Date end_date,
                         Integer max, String course_code, long location_id) {
        this.course_session_id = course_session_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.max = max;
        this.course_code = course_code;
        this.location_id = location_id;
    }

    public long getCourse_session_id() {
        return course_session_id;
    }

    public void setCourse_session_id(long course_session_id) {
        this.course_session_id = course_session_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "course_session_id=" + course_session_id + ", start_date=" + start_date + "end_date=" + end_date + ", max=" + max + "course_code=" + course_code + ", location_id=" + location_id + '}';
    }
}