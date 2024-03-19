package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.*;
import com.test.testtaskjunior.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ModelDao {
    private final EntityManager entityManager;

    public List<Object> findModelsByCriteria(SearchCriteria searchCriteria) { //TODO не работает
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

        Root<TelevisionSet> rootTV = criteriaQuery.from(TelevisionSet.class);
        Root<VacuumCleaner> rootVacuum = criteriaQuery.from(VacuumCleaner.class);
        Root<Fridge> rootFridge = criteriaQuery.from(Fridge.class);
        Root<Smartphone> rootSmartphone = criteriaQuery.from(Smartphone.class);
        Root<Computer> rootComputer = criteriaQuery.from(Computer.class);

        criteriaQuery.where(buildPredicates(criteriaBuilder, rootTV, rootVacuum, rootFridge, rootSmartphone, rootComputer, searchCriteria));

        criteriaQuery.multiselect(rootTV, rootVacuum, rootFridge, rootSmartphone);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private Predicate[] buildPredicates(CriteriaBuilder criteriaBuilder, Root<TelevisionSet> rootTV, Root<VacuumCleaner> rootVacuum, Root<Fridge> rootFridge,
                                        Root<Smartphone> rootSmartphone, Root<Computer> rootComputer, SearchCriteria searchCriteria) {
        List<Predicate> predicates = new ArrayList<>();

        for (Field field: searchCriteria.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(searchCriteria) != null) {
                    if (!ClassUtils.isPrimitiveOrWrapper(field.get(searchCriteria).getClass())) {
                        predicates.add(criteriaBuilder.and(criteriaBuilder.equal(rootTV.get(field.getName()), field.get(searchCriteria)),
                                criteriaBuilder.equal(rootVacuum.get(field.getName()), field.get(searchCriteria)),
                                criteriaBuilder.equal(rootFridge.get(field.getName()), field.get(searchCriteria)),
                                criteriaBuilder.equal(rootSmartphone.get(field.getName()), field.get(searchCriteria)),
                                criteriaBuilder.equal(rootComputer.get(field.getName()), field.get(searchCriteria))));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return predicates.toArray(new Predicate[] {});
    }
}
