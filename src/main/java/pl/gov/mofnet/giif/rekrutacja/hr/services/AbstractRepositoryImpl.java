package pl.gov.mofnet.giif.rekrutacja.hr.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractRepositoryImpl<E, PK> implements EntityRepository<E, PK> {

    @PersistenceContext
    private EntityManager em;

    private Class<E> entityClass;

    public AbstractRepositoryImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    protected abstract PK getPrimaryKey(E entity);

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void create(E entity) {
        getEntityManager().persist(entity);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public E edit(E entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void remove(E entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public E find(PK id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public List<E> findRange(int first, int count) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setFirstResult(first);
        q.setMaxResults(count);
        return q.getResultList();
    }

    @Override
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<E> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
