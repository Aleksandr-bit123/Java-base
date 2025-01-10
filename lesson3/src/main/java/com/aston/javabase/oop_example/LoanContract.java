package com.aston.javabase.oop_example;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 * Договор кредитования
 */
public class LoanContract extends BaseContract {

    /*
     * Сумма заемных средств
     */
    private BigDecimal borrowedAmount;

    /*
     * Является ли договор обеспеченным
     */
    private Boolean isCollateral;

    protected LoanContract(String contractNumber, LocalDateTime dateOfConclusion) {
        super(contractNumber, dateOfConclusion);
    }
}
