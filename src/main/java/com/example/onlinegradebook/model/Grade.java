package com.example.onlinegradebook.model;


public class Grade {
    private static Long lastGradeId = 1000000L;
    private Long id;
    private int value;

    public Grade(int value) {
        this.id = lastGradeId++;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "\tValue: " + this.value;
    }
}
