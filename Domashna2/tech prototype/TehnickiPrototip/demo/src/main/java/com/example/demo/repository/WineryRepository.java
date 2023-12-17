package com.example.demo.repository;

import com.example.demo.model.winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WineryRepository extends JpaRepository<winery, Long> {
    List<winery> findByCityIgnoreCase(String city);
    List<winery> findByNameContainingIgnoreCase(String name);
    List<winery> findByCityIgnoreCaseAndNameIgnoreCase(String name, String city);
    Optional<winery> findById(Long id);
}