/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.controller;

import pl.gov.mofnet.giif.rekrutacja.hr.services.EmployeeDao;
import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ksm
 */
@RequestScoped
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    EmployeeDao employeeDao;
    
    @Override
    public List<EmployeeTO> getAllEmployees() {
        return employeeDao.findAll().stream()
                .map(employee -> new EmployeeTOBuilder(employee).fillDepartment().build())
                .collect(Collectors.toList());
    }
    
}
