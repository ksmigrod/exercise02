package pl.gov.mofnet.giif.rekrutacja.controller;

import pl.gov.mofnet.giif.rekrutacja.hr.to.EmployeeTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeTO> getAllEmployees();
}
