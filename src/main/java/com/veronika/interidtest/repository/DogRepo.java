package com.veronika.interidtest.repository;

import com.veronika.interidtest.repository.entity.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends JpaRepository<DogEntity, Long> {
}
