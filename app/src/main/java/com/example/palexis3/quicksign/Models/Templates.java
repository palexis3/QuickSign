package com.example.palexis3.quicksign.Models;


public class Templates {

    private String name;
    private String imageUrl;
    private String description;
    private String text;


    public Templates() {}

    public Templates(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setImageUrl(String url) {
        this.imageUrl = url;
    }

    public void setText(String text) {
        this.text = text;
    }
}
