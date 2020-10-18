package com.example.MedicineSupply;

public class MedicineNotFoundException extends RuntimeException {

    public MedicineNotFoundException(Long id) {
        super("Medicine id not found : " + id);
    }

}