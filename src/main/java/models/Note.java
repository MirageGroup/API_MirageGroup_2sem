package models;

public class Note {
    private int id;
    private int class_id;
    private String note;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClass_id() {
        return class_id;
    }
    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
} 
