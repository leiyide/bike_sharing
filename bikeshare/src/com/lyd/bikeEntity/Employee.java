package com.lyd.bikeEntity;

public class Employee {
    private Integer employeeId;

    private Integer employeeRank;

    private String employeeName;

    private String employeeSysname;

    private String employeePhone;

    private String employeeEmail;

    private String employeeIdcard;

    private String employeePassword;

    private Integer employeeIsjob;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeRank() {
        return employeeRank;
    }

    public void setEmployeeRank(Integer employeeRank) {
        this.employeeRank = employeeRank;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getEmployeeSysname() {
        return employeeSysname;
    }

    public void setEmployeeSysname(String employeeSysname) {
        this.employeeSysname = employeeSysname == null ? null : employeeSysname.trim();
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone == null ? null : employeePhone.trim();
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail == null ? null : employeeEmail.trim();
    }

    public String getEmployeeIdcard() {
        return employeeIdcard;
    }

    public void setEmployeeIdcard(String employeeIdcard) {
        this.employeeIdcard = employeeIdcard == null ? null : employeeIdcard.trim();
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword == null ? null : employeePassword.trim();
    }

    public Integer getEmployeeIsjob() {
        return employeeIsjob;
    }

    public void setEmployeeIsjob(Integer employeeIsjob) {
        this.employeeIsjob = employeeIsjob;
    }
}