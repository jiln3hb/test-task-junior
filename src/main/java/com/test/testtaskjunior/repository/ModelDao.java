package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.*;
import com.test.testtaskjunior.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ModelDao {
    private final EntityManager entityManager;

    public List<Model> findModelsByCriteria(SearchCriteria searchCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Model> criteriaQuery = criteriaBuilder.createQuery(Model.class);

        Root<TelevisionSet> rootTV = criteriaQuery.from(TelevisionSet.class);
        Root<VacuumCleaner> rootVacuum = criteriaQuery.from(VacuumCleaner.class);
        //Root<Fridge> rootFridge = criteriaQuery.from(Fridge.class);
        //Root<Smartphone> rootSmartphone = criteriaQuery.from(Smartphone.class);
        //Root<Computer> rootComputer = criteriaQuery.from(Computer.class);

        criteriaQuery.multiselect(rootTV, rootVacuum);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
