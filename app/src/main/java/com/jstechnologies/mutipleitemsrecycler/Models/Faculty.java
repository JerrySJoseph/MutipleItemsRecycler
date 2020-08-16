package com.jstechnologies.mutipleitemsrecycler.Models;

public class Faculty extends User{
    String subject,salary;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
