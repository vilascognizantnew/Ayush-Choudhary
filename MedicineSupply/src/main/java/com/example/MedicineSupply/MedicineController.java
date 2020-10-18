package com.example.MedicineSupply;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MedicineController {

    
	@Autowired
    private MedicineRepository repository;

    
    @GetMapping("/medicines")
    List<Medicine> findAll() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/medicine")
    Medicine newMedicine(@RequestBody Medicine newMedicine) {
        return Repositories.save(newMedicine);
    }

    // Find
    @GetMapping("/medicine/{id}")
    Medicine findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(id));
    }

    // Save or update
    @PutMapping("/medicines/{id}")
    Medicine saveOrUpdate(@RequestBody Medicine newMedicine, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setName(newMedicine.getName());
                   
                    x.setPrice(newMedicine.getPrice());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newMedicine.setId(id);
                    return repository.save(newMedicine);
                });
    }

    // update author only
  

    @DeleteMapping("/medicines/{id}")
    void deleteMedicine(@PathVariable Long id) {
        repository.deleteById(id);
    }

}