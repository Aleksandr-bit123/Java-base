package com.aston.javabase.oop_example;

import java.time.LocalDateTime;

/*
* Договор банковского счета для вклада
*/
public class DepositBaseAccountContract extends BaseAccountContract {

    protected DepositBaseAccountContract(String contractNumber, LocalDateTime dateOfConclusion) {
        super(contractNumber, dateOfConclusion);
    }
}
