package com.example.chatapp.model;

public class Listitems {
    String countryName;
    int Image;
    String people;

    public Listitems(String countryName, int image, String people) {
        this.countryName = countryName;
        Image = image;
        this.people = people;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
