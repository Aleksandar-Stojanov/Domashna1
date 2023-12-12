package com.example.demo.repository;
import com.example.demo.model.Users_winery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface Users_winery_Repository extends JpaRepository<Users_winery, Long> {
    Users_winery findByUsernameAndPassword(String username, String password);
    @Modifying
    @Query(value = "INSERT INTO Users_winery (username,name, surname, password, date_of_birth, email) " +
            "VALUES (:username, :name, :surname, :password, :dateOfBirth, :email) ", nativeQuery = true)
    @Transactional
    void saveuser(@Param("username") String username,
                  @Param("name") String name,
                  @Param("surname") String surname,
                  @Param("password") String password,
                  @Param("dateOfBirth") LocalDate dateOfBirth,
                  @Param("email") String email);
    Users_winery findByUsername(String username);
    Optional<Users_winery> findById(Long id);

}
