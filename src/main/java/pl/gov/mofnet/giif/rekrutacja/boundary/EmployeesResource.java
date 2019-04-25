/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.boundary;

import pl.gov.mofnet.giif.rekrutacja.controller.EmployeeService;
import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author ksm
 */
@RequestScoped
@Path("employees")
public class EmployeesResource {
    
    @Inject
    EmployeeService employeeService;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeTO> listOfEmployees() {
        return employeeService.getAllEmployees();
    }
    
}
