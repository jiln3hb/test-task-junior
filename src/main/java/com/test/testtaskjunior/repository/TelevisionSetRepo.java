package com.test.testtaskjunior.repository;

import com.test.testtaskjunior.entity.TelevisionSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelevisionSetRepo extends JpaRepository<TelevisionSet, Long> {
}
