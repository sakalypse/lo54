package com.lo54.lo54ecole.entity;

import org.hibernate.type.StringType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "COURSE_SESSION")
public class CourseSession implements Serializable {

    private long course_session_id;
    private Date start_date;
    private Date end_date;
    private Integer max;
    private Course course;
    private Location location;

    public CourseSession() {

    }

    public CourseSession(Date start_date, Date end_date,
                         Integer max, Course course, Location location) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public CourseSession(long course_session_id, Date start_date, Date end_date,
                         Integer max, Course course, Location location) {
        this.course_session_id = course_session_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    @Id
    @Column(name = "course_session_id", unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getCourse_session_id() {
        return course_session_id;
    }
    public void setCourse_session_id(long course_session_id) {
        this.course_session_id = course_session_id;
    }

    @Column(name = "start_date")
    public Date getStart_date() {
        return start_date;
    }
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Column(name = "end_date")
    public Date getEnd_date() {
        return end_date;
    }
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Column(name = "max")
    public Integer getMax() {
        return max;
    }
    public void setMax(Integer max) {
        this.max = max;
    }

    @ManyToOne( cascade = {CascadeType.REMOVE} )
    @JoinColumn(name="course_code")
    public Course getCourse_code() { return course; }
    public void setCourse_code(Course course) {
        this.course = course;
    }

    @ManyToOne( cascade = {CascadeType.REMOVE} )
    @JoinColumn(name="location_id")
    public Location getLocation_id() {
        return location;
    }
    public void setLocation_id(Location location) { this.location = location; }

    @Override
    public String toString() {
        return "CourseSession{" + "course_session_id=" + course_session_id + ", start_date=" + start_date + "end_date=" + end_date + ", max=" + max + "course=" + course + ", location=" + location + '}';
    }
}