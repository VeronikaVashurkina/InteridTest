package com.veronika.interidtest.repository;

import com.veronika.interidtest.repository.entity.BirdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepo extends JpaRepository<BirdEntity, Long> {
}
