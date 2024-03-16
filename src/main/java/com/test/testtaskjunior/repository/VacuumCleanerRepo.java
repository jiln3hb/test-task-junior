package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacuumCleanerRepo extends JpaRepository<VacuumCleaner, Long> {
}
