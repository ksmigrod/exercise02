package pl.gov.mofnet.giif.rekrutacja.hr.services;

import pl.gov.mofnet.giif.rekrutacja.hr.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EmployeeDaoImpl extends AbstractRepositoryImpl<Employee, Integer> implements EmployeeDao {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    @Override
    protected Integer getPrimaryKey(Employee entity) {
        return entity.getId();
    }
}
