package com.csea.courseselection;

public class Course {
    private int cid;
    private String cname;
    private String cdomain;

    // Default Constructor
    public Course() {}

    // Parameterized Constructor
    public Course(int cid, String cname, String cdomain) {
        this.cid = cid;
        this.cname = cname;
        this.cdomain = cdomain;
    }

    // Getters and Setters
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdomain() {
        return cdomain;
    }

    public void setCdomain(String cdomain) {
        this.cdomain = cdomain;
    }
}
