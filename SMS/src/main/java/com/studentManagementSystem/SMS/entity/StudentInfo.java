package com.studentManagementSystem.SMS.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_info")
public class StudentInfo {
    @Id
    private String id;
    private String name;
    private String studentClass;
    private String parentName;
    private String email;
    private String contactNumber;

    public StudentInfo() {
    }

    public StudentInfo(String name, String studentClass, String parentName, String email, String contactNumber) {
        this.name = name;
        this.studentClass = studentClass;
        this.parentName = parentName;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
