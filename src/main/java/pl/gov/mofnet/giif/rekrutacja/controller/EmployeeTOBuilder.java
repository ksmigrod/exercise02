/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.controller;

import pl.gov.mofnet.giif.rekrutacja.hr.model.Department;
import pl.gov.mofnet.giif.rekrutacja.hr.model.Employee;
import pl.gov.mofnet.giif.rekrutacja.hr.to.DepartmentTO;
import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;

/**
 * Builds transfer object based on Employee.
 *
 * @author ksm
 */
public class EmployeeTOBuilder {

    private final Employee employee;
    private EmployeeTO result;

    /**
     * Creates builder based on Employee.
     *
     * @param employee Source of Employee data.
     */
    public EmployeeTOBuilder(Employee employee) {
        this.employee = employee;
        this.result = fillInBasicFields(employee);
    }

    /**
     * Adds department details to transfer object.
     *
     * @return this
     */
    public EmployeeTOBuilder fillDepartment() {
        Department dep = employee.getDepartment();
        if (dep != null) {
            DepartmentTO depTo = new DepartmentTO();
            depTo.setId(dep.getId());
            depTo.setName(dep.getName());
            result.setDepartment(depTo);
        }
        return this;
    }

    /**
     * Returns builded transfer object.
     *
     * @return Transfer object.
     */
    public EmployeeTO build() {
        return result;
    }

    private EmployeeTO fillInBasicFields(Employee employee) {
        EmployeeTO result = new EmployeeTO();
        result.setId(employee.getId());
        result.setFirstName(employee.getFirstName());
        result.setLastName(employee.getLastName());
        return result;
    }
}
