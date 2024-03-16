package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FridgeRepo extends JpaRepository<Fridge, Long> {
}
