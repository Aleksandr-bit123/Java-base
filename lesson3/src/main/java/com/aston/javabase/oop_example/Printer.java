package com.aston.javabase.oop_example;

import java.time.LocalDateTime;

public class Printer {

    public String getContractNumber(BaseContract baseContract) {
        return baseContract.getContractNumber();
    }

    public LocalDateTime getDateOfConclusion(BaseContract baseContract) {
        return baseContract.getDateOfConclusion();
    }
}
