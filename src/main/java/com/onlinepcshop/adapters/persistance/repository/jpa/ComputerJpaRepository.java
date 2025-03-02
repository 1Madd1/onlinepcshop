package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ComputerDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ComputerJpaRepository extends JpaRepository<ComputerDao, UUID> {
    List<ComputerDao> findAllByQuantityGreaterThanAndComputerTypeContainingIgnoreCase(Integer quantity, String computerType);

    List<ComputerDao> findBySaleTypeNotNullAndComputerNameContainingIgnoreCaseAndQuantityGreaterThan(String computerName, Integer quantity);

    List<ComputerDao> findByDateOfCreationAfterAndComputerNameContainingIgnoreCaseAndQuantityGreaterThan(LocalDate date, String computerName, Integer quantity);

    @Transactional
    @Query("SELECT c FROM computer c WHERE c.computerName LIKE CONCAT('%', ?1, '%') AND c.computerType LIKE CONCAT('%', ?2, '%') AND c.quantity > 0")
    List<ComputerDao> findComputersByComputerNameAndType(String name, String type);
}
