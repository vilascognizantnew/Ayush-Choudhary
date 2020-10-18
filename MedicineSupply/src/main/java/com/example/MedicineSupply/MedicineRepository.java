package com.example.MedicineSupply;

import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data magic :)
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}