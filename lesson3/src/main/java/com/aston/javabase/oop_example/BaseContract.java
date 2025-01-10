package com.aston.javabase.oop_example;

import java.time.LocalDateTime;

/*
 * Договор банковского обслуживания
 */
public abstract class BaseContract {

    /*
     * Номер договора
     */
    private final String contractNumber;
    /*
     * Дата заключения договора
     */
    private final LocalDateTime dateOfConclusion;

    protected BaseContract(String contractNumber, LocalDateTime dateOfConclusion) {
        this.contractNumber = contractNumber;
        this.dateOfConclusion = dateOfConclusion;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public LocalDateTime getDateOfConclusion() {
        return dateOfConclusion;
    }
}
