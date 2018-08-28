package com.planetinnovative.firebaseproject.Database;


public class NotesDetailModel {
    public String id;
    public String title;
    public String priority;
    public String detail;

    public NotesDetailModel(String id, String title, String detail, String priority) {
        this.id = id;
        this.detail = detail;
        this.title = title;
        this.priority = priority;
    }

    public NotesDetailModel() {
    }
}
