package com.lo54.lo54ecole.entity;

import java.io.Serializable;

public class Client implements Serializable {

    private String title;
    private String genre;
    private Integer nbExemplaires;

    public Client() {
    
    }

    public Client(String title, String genre, Integer nbExemplaires) {
        this.title = title;
        this.genre = genre;
        this.nbExemplaires = nbExemplaires;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNbExemplaires() {
        return nbExemplaires;
    }

    public void setNbExemplaires(Integer nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }

    @Override
    public String toString() {
        return "Film{" + "title=" + title + ", genre=" + genre + ", nbExemplaires=" + nbExemplaires + '}';
    }
}