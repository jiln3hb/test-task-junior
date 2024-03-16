package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepo extends JpaRepository<Smartphone, Long> {
}
