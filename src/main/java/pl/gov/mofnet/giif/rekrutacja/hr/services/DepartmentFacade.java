package pl.gov.mofnet.giif.rekrutacja.hr.services;

import pl.gov.mofnet.giif.rekrutacja.hr.model.Department;

import javax.annotation.Generated;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Generated("NetBeans")
public class DepartmentFacade extends AbstractFacade<Department> implements DepartmentFacadeLocal {

    @PersistenceContext(unitName = "HRPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentFacade() {
        super(Department.class);
    }
    
}
