/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.hr.to;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ksm
 */
public class EmployeeTO implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private DepartmentTO department;
    
    public EmployeeTO() {
    }

    public EmployeeTO(Integer id, String firstName, String lastName, DepartmentTO department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
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

    public DepartmentTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentTO department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeTO that = (EmployeeTO) o;
        return id.equals(that.id) &&
                Objects.equals(firstName, that.firstName) &&
                lastName.equals(that.lastName) &&
                Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, department);
    }

    @Override
    public String toString() {
        return "EmployeeTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                '}';
    }
}
