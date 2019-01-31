/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.controller;

import pl.gov.mofnet.giif.rekrutacja.hr.services.EmployeeFacadeLocal;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;

/**
 *
 * @author ksm
 */
@Stateless
public class EmployeeService implements EmployeeServiceLocal {

    @EJB EmployeeFacadeLocal employeeFacade;
    
    public List<EmployeeTO> getAllEmployees() {
        return employeeFacade.findAll().stream()
                .map(employee -> new EmployeeTOBuilder(employee).fillDepartment().build())
                .collect(Collectors.toList());
    }
    
}
