package pl.gov.mofnet.giif.rekrutacja.hr.services;

import pl.gov.mofnet.giif.rekrutacja.hr.model.Department;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DepartmentDaoImpl extends AbstractRepositoryImpl<Department, Short> implements DepartmentDao {

    public DepartmentDaoImpl() {
        super(Department.class);
    }

    @Override
    protected Short getPrimaryKey(Department entity) {
        return entity.getId();
    }
}
