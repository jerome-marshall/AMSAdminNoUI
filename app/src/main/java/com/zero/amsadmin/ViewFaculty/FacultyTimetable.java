package com.zero.amsadmin.ViewFaculty;

import com.zero.amsadmin.UserID;

public class FacultyTimetable extends UserID {
    String dept;
    String sub;

    public FacultyTimetable() {
    }

    public String getDept() {
        return dept;
    }

    public String getSub() {
        return sub;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public FacultyTimetable(String dept, String sub) {
        this.dept = dept;
        this.sub = sub;
    }
}
