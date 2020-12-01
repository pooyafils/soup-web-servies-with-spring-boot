package com.DevUp.test.Bean;

public class Student {
    private int id;
    private String name;
    private String familyname;

    public Student(int id, String name, String familyname) {
        this.id = id;
        this.name = name;
        this.familyname = familyname;
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

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyname='" + familyname + '\'' +
                '}';
    }
}
