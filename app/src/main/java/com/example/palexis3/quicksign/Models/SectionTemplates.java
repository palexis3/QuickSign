package com.example.palexis3.quicksign.Models;


import java.util.ArrayList;

public class SectionTemplates {

    private String description;
    private ArrayList<Templates> templatesArrayList;

    public SectionTemplates() {};

    public SectionTemplates(String description, ArrayList<Templates> templatesArrayList) {
        this.description = description;
        this.templatesArrayList = templatesArrayList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Templates> getTemplatesArrayList() {
        return templatesArrayList;
    }

    public void setTemplatesArrayList(ArrayList<Templates> templatesArrayList) {
        this.templatesArrayList = templatesArrayList;
    }

}
