/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.controller;

import java.util.List;
import javax.ejb.Local;
import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;

/**
 *
 * @author ksm
 */
@Local
public interface EmployeeServiceLocal {

    public List<EmployeeTO> getAllEmployees();
    
}
