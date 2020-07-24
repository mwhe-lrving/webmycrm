package com.mycrm.pojo;

public class Employee {
    private int empid;
    private String realname;
    private String username;
    private String password;
    private String tel;
    private String email;

    public Employee() {
    }

    public Employee(int empid, String realname, String username, String password, String tel, String email) {
        this.empid = empid;
        this.realname = realname;
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", realname='" + realname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
