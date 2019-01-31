package pl.gov.mofnet.giif.rekrutacja.hr.services;

import pl.gov.mofnet.giif.rekrutacja.hr.model.Department;
import java.util.List;
import javax.annotation.Generated;
import javax.ejb.Local;

@Local
@Generated("NetBeans")
public interface DepartmentFacadeLocal {

    void create(Department department);

    void edit(Department department);

    void remove(Department department);

    Department find(Object id);

    List<Department> findAll();

    List<Department> findRange(int[] range);

    int count();
    
}
