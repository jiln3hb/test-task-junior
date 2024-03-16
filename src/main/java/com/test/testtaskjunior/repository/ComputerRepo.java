package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepo extends JpaRepository<Computer, Long> {
}
