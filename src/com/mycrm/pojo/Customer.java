package com.mycrm.pojo;

public class Customer {
    private int custid;
    private String custname;
    private String contacts;
    private String tel;
    private String email;
    private int empid;

    public Customer() {
        System.out.println("Customer无参构造器");
    }

    public Customer(int custid, String custname, String contacts, String tel, String email) {
        this.custid = custid;
        this.custname = custname;
        this.contacts = contacts;
        this.tel = tel;
        this.email = email;
    }

    public Customer(String custname, String contacts, String tel, String email, int empid) {
        this.custname = custname;
        this.contacts = contacts;
        this.tel = tel;
        this.email = email;
        this.empid = empid;
    }

    public Customer(int custid, String custname, String contacts, String tel, String email, int empid) {
        this.custid = custid;
        this.custname = custname;
        this.contacts = contacts;
        this.tel = tel;
        this.email = email;
        this.empid = empid;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custid=" + custid +
                ", custname='" + custname + '\'' +
                ", contacts='" + contacts + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", empid=" + empid +
                '}';
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
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

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }
}
