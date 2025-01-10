package com.aston.javabase.oop_example;

import java.time.LocalDateTime;

/*
* Договор банковского счета для обслуживания бюджетных операций
*/
public class BudgetBaseAccountContract extends BaseAccountContract {

    protected BudgetBaseAccountContract(String contractNumber, LocalDateTime dateOfConclusion) {
        super(contractNumber, dateOfConclusion);
    }
}
