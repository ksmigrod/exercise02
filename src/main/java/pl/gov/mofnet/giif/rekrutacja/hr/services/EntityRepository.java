package pl.gov.mofnet.giif.rekrutacja.hr.services;

import java.util.List;

public interface EntityRepository<E, PK> {

    void create(E entity);

    E edit(E entity);

    void remove(E entity);

    E find(PK id);

    List<E> findAll();

    List<E> findRange(int first, int count);

    int count();
}
