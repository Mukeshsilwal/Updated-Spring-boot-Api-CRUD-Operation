package com.example.demo.model;

public class StudentDto {

    int id;
    String name;
    String roll;
    String cName;

    public StudentDto() {
    }

    public StudentDto(int id, String name, String roll, String cName) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.cName = cName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
