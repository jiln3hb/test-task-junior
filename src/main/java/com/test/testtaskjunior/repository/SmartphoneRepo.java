package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepo extends JpaRepository<Smartphone, Long> {
}
