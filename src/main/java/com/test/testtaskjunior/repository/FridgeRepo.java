package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeRepo extends JpaRepository<Fridge, Long> {
}
