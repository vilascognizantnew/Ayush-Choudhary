package com.example.MedicineSupply;

import java.util.Set;

public class MedicineUnSupportedFieldPatchException extends RuntimeException {

    public MedicineUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}