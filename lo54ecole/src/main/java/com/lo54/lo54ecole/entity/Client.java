package com.lo54.lo54ecole.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {


    private long client_id;
    private String lastname;
    private String firstname;
    private String addresse;
    private String phone;
    private String email;
    private CourseSession course_session;

    public Client() {
    
    }

    public Client(String lastname, String firstname,
                  String addresse, String phone, String email, CourseSession course_session) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
        this.course_session = course_session;
    }

    public Client(long client_id, String lastname, String firstname, 
                  String addresse, String phone, String email, CourseSession course_session) {
        this.client_id = client_id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
        this.course_session = course_session;
    }

    @Id
    @Column(name = "client_id", unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getClient_id() {
        return client_id;
    }
    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "addresse")
    public String getAddresse() {
        return addresse;
    }
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name="course_session_id")
    public CourseSession getCourse_session_id() {
        return course_session;
    }
    public void setCourse_session_id(CourseSession course_session) {
        this.course_session = course_session;
    }

    @Override
    public String toString() {
        return "Client{" + "client_id=" + client_id + ", lastname=" + lastname + ", firstname=" + firstname + ", firstname=" + firstname + ", addresse=" + addresse + ", phone=" + phone + ", email=" + email + ", course_session=" + course_session + '}';
    }
}