/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.hr.to;

import java.io.Serializable;
import java.util.Objects;

public class DepartmentTO implements Serializable {
    
    private Short id;
    private String name;
    private Integer employeeCount;

    public DepartmentTO() {
    }

    public DepartmentTO(Short id, String name) {
        this(id, name, null);
    }

    public DepartmentTO(int id, String name) {
        this(Short.valueOf((short)id), name, null);
    }

    public DepartmentTO(int id, String name, Integer employeeCount) {
        this(Short.valueOf((short)id), name, employeeCount);
    }

    public DepartmentTO(Short id, String name, Integer employeeCount) {
        this.id = id;
        this.name = name;
        this.employeeCount = employeeCount;
    }

    public DepartmentTO(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentTO that = (DepartmentTO) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                Objects.equals(employeeCount, that.employeeCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employeeCount);
    }

    @Override
    public String toString() {
        return "DepartmentTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
