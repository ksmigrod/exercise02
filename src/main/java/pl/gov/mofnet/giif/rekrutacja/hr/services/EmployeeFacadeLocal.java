package pl.gov.mofnet.giif.rekrutacja.hr.services;

import pl.gov.mofnet.giif.rekrutacja.hr.model.Employee;
import java.util.List;
import javax.annotation.Generated;
import javax.ejb.Local;

@Local
@Generated("NetBeans")
public interface EmployeeFacadeLocal {

    void create(Employee employee);

    void edit(Employee employee);

    void remove(Employee employee);

    Employee find(Object id);

    List<Employee> findAll();

    List<Employee> findRange(int[] range);

    int count();
    
}
