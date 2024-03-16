package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacuumCleanerRepo extends JpaRepository<VacuumCleaner, Long> {
}
