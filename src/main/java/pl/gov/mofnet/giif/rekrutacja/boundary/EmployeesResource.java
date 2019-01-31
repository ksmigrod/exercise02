/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.boundary;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;
import pl.gov.mofnet.giif.rekrutacja.controller.EmployeeServiceLocal;

/**
 *
 * @author ksm
 */
@RequestScoped
@Path("employees")
public class EmployeesResource {
    
    @Inject EmployeeServiceLocal employeeService;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeTO> listOfEmployees() {
        return employeeService.getAllEmployees();
    }
    
}
