package org.etu.java.labs.repository;

import org.etu.java.labs.entity.IntelligentParkingSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntelligentParkingSystemRepository extends JpaRepository<IntelligentParkingSystem, String> {
}
