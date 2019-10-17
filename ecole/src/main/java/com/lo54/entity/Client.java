package com.lo54.lo54ecole.entity;

import java.io.Serializable;

public class Client implements Serializable {

    private long client_id;
    private String lastname;
    private String firstname;
    private String addresse;
    private String phone;
    private String email;
    private long course_session_id;

    public Client() {
    
    }

    public Client(long client_id, String lastname, String firstname, 
                  String addresse, String phone, String email, long course_session_id) {
        this.client_id = client_id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
        this.course_session_id = course_session_id;
    }

    public long getClientId() {
        return client_id;
    }

    public void setClientId(long client_id) {
        this.client_id = client_id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCourseSessionId() {
        return course_session_id;
    }

    public void setCourseSessionId(long course_session_id) {
        this.course_session_id = course_session_id;
    }

    @Override
    public String toString() {
        return "Client{" + "client_id=" + client_id + ", lastname=" + lastname + ", firstname=" + firstname + ", firstname=" + firstname + ", addresse=" + addresse + ", phone=" + phone + ", email=" + email + ", course_session_id=" + course_session_id + '}';
    }
}