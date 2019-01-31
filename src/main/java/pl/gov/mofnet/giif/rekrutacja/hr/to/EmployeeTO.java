/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.hr.to;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ksm
 */
public class EmployeeTO implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private DepartmentTO department;
    
    public EmployeeTO() {
    }

    public EmployeeTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public DepartmentTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentTO department) {
        this.department = department;
    }
    
}
